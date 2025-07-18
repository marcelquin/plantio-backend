package App.Domain.Bussness;

import App.Domain.Response.Floracao;
import App.Domain.Response.Frutificacao;
import App.Domain.Response.Germinacao;
import App.Domain.Response.Maturacao;
import App.Infra.Exceptions.EntityNotFoundException;
import App.Infra.Exceptions.NullargumentsException;
import App.Infra.Gateway.FloracaoCicloGateway;
import App.Infra.Mapper.FloracaoMapper;
import App.Infra.Mapper.GerminacaoMapper;
import App.Infra.Persistence.Entity.FloracaoEntity;
import App.Infra.Persistence.Entity.GerminacaoEntity;
import App.Infra.Persistence.Repository.FloracaoRepository;
import App.Infra.Persistence.Repository.GerminacaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FloracaoService implements FloracaoCicloGateway {


    private final FloracaoRepository floracaoRepository;
    private final FloracaoMapper floracaoMapper;

    public FloracaoService(FloracaoRepository floracaoRepository, FloracaoMapper floracaoMapper) {
        this.floracaoRepository = floracaoRepository;
        this.floracaoMapper = floracaoMapper;
    }

    @Override
    public ResponseEntity<Floracao> BuscarCorpoPorId(Long id)
    {
        try
        {
            if(id == null){throw new NullargumentsException();}
            FloracaoEntity entity = floracaoRepository.findById(id).orElseThrow(
                    EntityNotFoundException::new
            );
            Floracao response = floracaoMapper.EntityToDto(entity);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Floracao> NovoCiclo()
    {
        try
        {
            FloracaoEntity entity = new FloracaoEntity();
            entity.SetinfoInicial();
            floracaoRepository.save(entity);
            Floracao response = floracaoMapper.EntityToDto(entity);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Floracao> AtualizarEntidadeInicio(Long id)
    {
        try
        {
            if(id == null){throw new NullargumentsException();}
            Floracao floracao = BuscarCorpoPorId(id).getBody();
            FloracaoEntity entity = floracaoMapper.DtoToEntity(floracao);
            entity.Setdados();
            floracaoRepository.save(entity);
            Floracao response = floracaoMapper.EntityToDto(entity);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Floracao> AtualizarEntidadeFim(Long id)
    {
        try
        {
            if(id == null){throw new NullargumentsException();}
            Floracao floracao = BuscarCorpoPorId(id).getBody();
            FloracaoEntity entity = floracaoMapper.DtoToEntity(floracao);
            entity.FimCiclo();
            floracaoRepository.save(entity);
            Floracao response = floracaoMapper.EntityToDto(entity);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Floracao> SalvarAlteracao(Floracao floracao)
    {
        try
        {
            FloracaoEntity entity = floracaoMapper.DtoToEntity(floracao);
            floracaoRepository.save(entity);
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
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
