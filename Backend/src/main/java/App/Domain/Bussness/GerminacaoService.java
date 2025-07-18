package App.Domain.Bussness;

import App.Domain.Response.Germinacao;
import App.Infra.Exceptions.EntityNotFoundException;
import App.Infra.Exceptions.NullargumentsException;
import App.Infra.Gateway.GerminacaoCicloGateway;
import App.Infra.Mapper.GerminacaoMapper;
import App.Infra.Persistence.Entity.GerminacaoEntity;
import App.Infra.Persistence.Repository.GerminacaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GerminacaoService implements GerminacaoCicloGateway {


    private final GerminacaoRepository germinacaoRepository;
    private final GerminacaoMapper germinacaoMapper;

    public GerminacaoService(GerminacaoRepository germinacaoRepository, GerminacaoMapper germinacaoMapper) {
        this.germinacaoRepository = germinacaoRepository;
        this.germinacaoMapper = germinacaoMapper;
    }

    @Override
    public ResponseEntity<Germinacao> BuscarCorpoPorId(Long id)
    {
        try
        {
            if(id == null){throw new NullargumentsException();}
            GerminacaoEntity entity = germinacaoRepository.findById(id).orElseThrow(
                    EntityNotFoundException::new
            );
            Germinacao response = germinacaoMapper.EntityToDto(entity);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Germinacao> NovoCiclo()
    {
        try
        {
            GerminacaoEntity entity = new GerminacaoEntity();
            entity.Setdados();
            germinacaoRepository.save(entity);
            Germinacao response = germinacaoMapper.EntityToDto(entity);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Germinacao> AtualizarEntidadeFim(Long id)
    {
        try
        {
            if(id == null){throw new NullargumentsException();}
            Germinacao germinacao = BuscarCorpoPorId(id).getBody();
            GerminacaoEntity entity = germinacaoMapper.DtoToEntity(germinacao);
            entity.FimCiclo();
            germinacao = germinacaoMapper.EntityToDto(entity);
            SalvarAlteracao(germinacao);
            return new ResponseEntity<>(germinacao, HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Germinacao> SalvarAlteracao(Germinacao germinacao)
    {
        try
        {
            GerminacaoEntity entity = germinacaoMapper.DtoToEntity(germinacao);
            germinacaoRepository.save(entity);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Void> DeletarPorId(Long id)
    {
        try
        {
            if(id == null){throw new NullargumentsException();}
            Germinacao germinacao = BuscarCorpoPorId(id).getBody();
            germinacaoRepository.deleteById(germinacao.getId());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
