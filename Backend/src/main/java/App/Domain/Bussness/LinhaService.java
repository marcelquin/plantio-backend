package App.Domain.Bussness;

import App.Domain.Response.Linha;
import App.Domain.Response.Localizacao;
import App.Domain.Response.Plantio;
import App.Infra.Exceptions.EntityNotFoundException;
import App.Infra.Exceptions.NullargumentsException;
import App.Infra.Gateway.LinhaGateway;
import App.Infra.Mapper.LinhaMapper;
import App.Infra.Mapper.LocalizacaoMapper;
import App.Infra.Mapper.PlantioMapper;
import App.Infra.Persistence.Entity.LinhaEntity;
import App.Infra.Persistence.Entity.LocalizacaoEntity;
import App.Infra.Persistence.Repository.LinhaRepository;
import App.Infra.UseCase.Localizacao.UseCaseLocalizacaoDelete;
import App.Infra.UseCase.Localizacao.UseCaseLocalizacaoPut;
import App.Infra.UseCase.Planta.UseCasePlantaGet;
import App.Infra.UseCase.Plantio.UseCasePlantioGet;
import App.Infra.UseCase.Plantio.UseCasePlantioPut;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LinhaService implements LinhaGateway {


    private final UseCasePlantioGet useCasePlantioGet;
    private final UseCasePlantioPut useCasePlantioPut;
    private final LinhaRepository linhaRepository;
    private final LinhaMapper linhaMapper;
    private final UseCaseLocalizacaoPut caseLocalizacaoPut;
    private final UseCaseLocalizacaoDelete useCaseLocalizacaoDelete;

    public LinhaService(@Lazy UseCasePlantioGet useCasePlantioGet,
                        @Lazy UseCasePlantioPut useCasePlantioPut,
                        LinhaRepository linhaRepository,
                        LinhaMapper linhaMapper,
                        @Lazy UseCaseLocalizacaoPut caseLocalizacaoPut,
                        @Lazy UseCaseLocalizacaoDelete useCaseLocalizacaoDelete) {
        this.useCasePlantioGet = useCasePlantioGet;
        this.useCasePlantioPut = useCasePlantioPut;
        this.linhaRepository = linhaRepository;
        this.linhaMapper = linhaMapper;
        this.caseLocalizacaoPut = caseLocalizacaoPut;
        this.useCaseLocalizacaoDelete = useCaseLocalizacaoDelete;
    }


    @Override
    public ResponseEntity<List<Linha>> ListarLinhas()
    {
        try
        {
            List<LinhaEntity> entities = linhaRepository.findAll();
            List<Linha> response = new ArrayList<>();
            for(LinhaEntity entity : entities)
            {
                Linha dto = linhaMapper.EntityToDto(entity);
                response.add(dto);
            }
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Linha> BuscarLinhaPorId(Long id)
    {
        try
        {
            if(id == null){throw new NullargumentsException();}
            LinhaEntity entity = linhaRepository.findById(id).orElseThrow(
                    EntityNotFoundException::new
            );
            Linha response = linhaMapper.EntityToDto(entity);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Linha> BuscarLinhaPorIentificador(String identidicador)
    {
        try
        {
            if(identidicador == null){throw new NullargumentsException();}
            LinhaEntity entity = linhaRepository.findByidentificador(identidicador).orElseThrow(
                    EntityNotFoundException::new
            );
            Linha response = linhaMapper.EntityToDto(entity);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Linha> NovaLinha(Long plantioId)
    {
        try
        {
            if(plantioId == null) {throw new NullargumentsException();}
            Plantio plantio = useCasePlantioGet.BuscarPlantioPorId(plantioId).getBody();
            int linhaAtual = plantio.getLinhas().size()+1;
            LinhaEntity entity = new LinhaEntity();
            entity.SetInfoInicial(plantio.getIdentificador(),linhaAtual);
            linhaRepository.save(entity);
            Linha response = linhaMapper.EntityToDto(entity);
            plantio.getLinhas().add(response);
            useCasePlantioPut.SalarAlteracao(plantio);
            return new ResponseEntity<>(response,HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Linha> AlterarIdentificador(Long linhaId, String identificadorPlantio)
    {
        try
        {
            if(linhaId == null) {throw new NullargumentsException();}
            if(identificadorPlantio == null) {throw new NullargumentsException();}
            Linha linha = BuscarLinhaPorId(linhaId).getBody();
            LinhaEntity entity = linhaMapper.DtoToEntity(linha);
            entity.AlterarIdentificador(identificadorPlantio);
            linha = linhaMapper.EntityToDto(entity);
            SalvarAlteracao(linha);
            for(Localizacao localizacao : linha.getLocalizacoes())
            {
                caseLocalizacaoPut.AlterarReferencia(localizacao.getId(),linha.getIdentificador());
            }
            return new ResponseEntity<>(linha,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Linha> DeletarLinhaPorId(Long linhaId)
    {
        try
        {
            if(linhaId == null) {throw new NullargumentsException();}
            Linha linha = BuscarLinhaPorId(linhaId).getBody();
            //mensagem
            String original = linha.getIdentificador();
            String[] partes = original.split(":");
            String plantioIdentificador = partes[0];
            //mensagem
            Plantio plantio = useCasePlantioGet.BuscarPlantioPorIdentificador(plantioIdentificador).getBody();
            List<Linha>linhaEntities = new ArrayList<>();
            for(Linha linhaInterna : plantio.getLinhas())
            {
                if(linhaInterna.getId() != linha.getId())
                {
                    linhaEntities.add(linhaInterna);
                }
            }
            plantio.setLinhas(linhaEntities);
            useCasePlantioPut.SalarAlteracao(plantio);
            for(Localizacao localizacao : linha.getLocalizacoes())
            {
                useCaseLocalizacaoDelete.DeletarLocalizacaoPorId(localizacao.getId());
            }
            linhaRepository.deleteById(linha.getId());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Void> SalvarAlteracao(Linha linha)
    {
        try
        {
            if(linha == null){throw new NullargumentsException();}
            LinhaEntity entity = linhaMapper.DtoToEntity(linha);
            linhaRepository.save(entity);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


}
