package App.Domain.Bussness;

import App.Domain.Response.Linha;
import App.Domain.Response.Localizacao;
import App.Domain.Response.Planta;
import App.Infra.Exceptions.EntityNotFoundException;
import App.Infra.Exceptions.IllegalActionException;
import App.Infra.Exceptions.NullargumentsException;
import App.Infra.Gateway.LocalizacaoGateway;
import App.Infra.Mapper.LocalizacaoMapper;
import App.Infra.Mapper.PlantaMapper;
import App.Infra.Persistence.Entity.LocalizacaoEntity;
import App.Infra.Persistence.Entity.PlantaEntity;
import App.Infra.Persistence.Enum.CICLO;
import App.Infra.Persistence.Repository.LocalizacaoRepository;
import App.Infra.UseCase.Linha.UseCaseLinhaGet;
import App.Infra.UseCase.Linha.UseCaseLinhaPut;
import App.Infra.UseCase.Planta.UseCasePlantaDelete;
import App.Infra.UseCase.Planta.UseCasePlantaGet;
import App.Infra.UseCase.Planta.UseCasePlantaPut;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class LocalizacaoService implements LocalizacaoGateway {

    private final LocalizacaoRepository localizacaoRepository;
    private final LocalizacaoMapper localizacaoMapper;
    private final PlantaMapper plantaMapper;
    private final UseCaseLinhaGet useCaseLinhaGet;
    private final UseCaseLinhaPut useCaseLinhaPut;
    private final UseCasePlantaGet casePlantaGet;
    private final UseCasePlantaPut casePlantaPut;
    private final UseCasePlantaDelete casePlantaDelete;

    public LocalizacaoService(LocalizacaoRepository localizacaoRepository,
                              LocalizacaoMapper localizacaoMapper,
                              PlantaMapper plantaMapper,
                              @Lazy UseCaseLinhaGet useCaseLinhaGet,
                              @Lazy UseCaseLinhaPut useCaseLinhaPut,
                              @Lazy UseCasePlantaGet casePlantaGet,
                              @Lazy UseCasePlantaPut casePlantaPut,
                              @Lazy UseCasePlantaDelete casePlantaDelete) {
        this.localizacaoRepository = localizacaoRepository;
        this.localizacaoMapper = localizacaoMapper;
        this.plantaMapper = plantaMapper;
        this.useCaseLinhaGet = useCaseLinhaGet;
        this.useCaseLinhaPut = useCaseLinhaPut;
        this.casePlantaGet = casePlantaGet;
        this.casePlantaPut = casePlantaPut;
        this.casePlantaDelete = casePlantaDelete;
    }

    @Override
    public ResponseEntity<List<Localizacao>> ListarLocalizacoes()
    {
        try
        {
            List<LocalizacaoEntity> localizacaoEntities = localizacaoRepository.findAll();
            List<Localizacao> response = new ArrayList<>();
            for(LocalizacaoEntity entity : localizacaoEntities)
            {
                Localizacao dto = localizacaoMapper.EntityToDto(entity);
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
    public ResponseEntity<List<Localizacao>> ListarLocalizacoesDisponiveis()
    {
        try
        {
            List<LocalizacaoEntity> localizacaoEntities = localizacaoRepository.findAll();
            List<Localizacao> response = new ArrayList<>();
            for(LocalizacaoEntity entity : localizacaoEntities)
            {
                if(entity.getDisponivel().equals(Boolean.TRUE))
                {
                    Localizacao dto = localizacaoMapper.EntityToDto(entity);
                    response.add(dto);
                }
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
    public ResponseEntity<List<Localizacao>> ListarLocalizacoesNaoDisponiveis()
    {
        try
        {
            List<LocalizacaoEntity> localizacaoEntities = localizacaoRepository.findAll();
            List<Localizacao> response = new ArrayList<>();
            for(LocalizacaoEntity entity : localizacaoEntities)
            {
                if(entity.getDisponivel().equals(Boolean.FALSE))
                {
                    Localizacao dto = localizacaoMapper.EntityToDto(entity);
                    response.add(dto);
                }
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
    public ResponseEntity<Localizacao> BuscarLocalizacaoPorId(Long id)
    {
        try
        {
            if(id == null) {throw new NullargumentsException();}
            LocalizacaoEntity entity = localizacaoRepository.findById(id).orElseThrow(
                    EntityNotFoundException::new
            );
            Localizacao response = localizacaoMapper.EntityToDto(entity);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Localizacao> BuscarLocalizacaoPorReferencia(String referencia)
    {
        try
        {
            if(referencia == null) {throw new NullargumentsException();}
            LocalizacaoEntity entity = localizacaoRepository.findByreferencia(referencia).orElseThrow(
                    EntityNotFoundException::new
            );
            Localizacao response = localizacaoMapper.EntityToDto(entity);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Localizacao> IndisponibilizarLocalizacao(Long localizacaoId, Planta planta)
    {
        try
        {
            if(localizacaoId == null){throw new NullargumentsException();}
            if(planta == null){throw new NullargumentsException();}
            Localizacao localizacao = BuscarLocalizacaoPorId(localizacaoId).getBody();
            LocalizacaoEntity entity = localizacaoMapper.DtoToEntity(localizacao);
            PlantaEntity plantaEntity = plantaMapper.DtoToEntity(planta);
            entity.Indisponibilizar(plantaEntity);
            localizacao = localizacaoMapper.EntityToDto(entity);
            SalvarAlteracao(localizacao);
            return new ResponseEntity<>(localizacao,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Localizacao> DisponibilizarLocalizacao(Long localizacaoId)
    {
        try
        {
            if(localizacaoId == null){throw new NullargumentsException();}
            Localizacao localizacao = BuscarLocalizacaoPorId(localizacaoId).getBody();
            LocalizacaoEntity entity = localizacaoMapper.DtoToEntity(localizacao);
            entity.Disponibilizar();
            localizacao = localizacaoMapper.EntityToDto(entity);
            SalvarAlteracao(localizacao);
            return new ResponseEntity<>(localizacao,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Localizacao> NovaLocalizacao(Long linhaId)
    {
        try
        {
            Linha linha = useCaseLinhaGet.BuscarLinhaPorId(linhaId).getBody();
            int numeroLocalizacao = linha.getLocalizacoes().size()+1;
            LocalizacaoEntity entity = new LocalizacaoEntity();
            entity.SetInfoInicial(linha.getIdentificador(), numeroLocalizacao);
            localizacaoRepository.save(entity);
            Localizacao response = localizacaoMapper.EntityToDto(entity);
            linha.getLocalizacoes().add(response);
            useCaseLinhaPut.SalvarAlteracao(linha);
            return new ResponseEntity<>(response,HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Localizacao> AlterarReferencia(Long id, String identificadorLinha)
    {
        try
        {
            if(id == null){throw new NullargumentsException();}
            if(identificadorLinha == null){throw new NullargumentsException();}
            Localizacao localizacao = BuscarLocalizacaoPorId(id).getBody();
            LocalizacaoEntity entity = localizacaoMapper.DtoToEntity(localizacao);
            entity.AlterarReferencia(identificadorLinha);
            localizacao = localizacaoMapper.EntityToDto(entity);
            SalvarAlteracao(localizacao);
            if(localizacao.getPlanta() != null)
            {
                Planta planta = casePlantaGet.BuscarPlantaPorId(localizacao.getPlanta().getId()).getBody();
                casePlantaPut.AtualizarLocalizacao(planta.getId(),localizacao.getReferencia());
            }
            return new ResponseEntity<>(localizacao,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Void> SalvarAlteracao(Localizacao localizacao)
    {
        try
        {
            if(localizacao == null){throw new NullargumentsException();}
            LocalizacaoEntity entity = localizacaoMapper.DtoToEntity(localizacao);
            localizacaoRepository.save(entity);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Localizacao> DeletarLocalizacaoPorId(Long localizacaoId)
    {
        try
        {
            if(localizacaoId == null){throw new NullargumentsException();}
            Localizacao localizacao = BuscarLocalizacaoPorId(localizacaoId).getBody();
            String original = localizacao.getReferencia();
            String[] partes = original.split("-");
            String linhaIdentificador = partes[0];
            Linha linha = useCaseLinhaGet.BuscarLinhaPorIentificador(linhaIdentificador).getBody();
            List<Localizacao> localizacaoList = new ArrayList<>();
            for(Localizacao loc : linha.getLocalizacoes())
            {
                if(loc.getId() != localizacao.getId())
                {
                    localizacaoList.add(loc);
                }
            }
            linha.setLocalizacoes(localizacaoList);
            useCaseLinhaPut.SalvarAlteracao(linha);
            if(localizacao.getPlanta() != null)
            {
                long plantaId = localizacao.getPlanta().getId();
                localizacao.setPlanta(null);
                SalvarAlteracao(localizacao);
                //casePlantaDelete.DeletarPlantaPorId(localizacao.getPlanta().getId());
                casePlantaPut.AlterarCiclo(plantaId, "FIM");
            }
            localizacaoRepository.deleteById(localizacaoId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
