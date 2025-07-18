package App.Domain.Bussness;

import App.Domain.Response.Germinacao;
import App.Domain.Response.Muda;
import App.Infra.Exceptions.EntityNotFoundException;
import App.Infra.Exceptions.NullargumentsException;
import App.Infra.Gateway.MudaCicloGateway;
import App.Infra.Mapper.MudaMapper;
import App.Infra.Persistence.Entity.GerminacaoEntity;
import App.Infra.Persistence.Entity.MudaEntity;
import App.Infra.Persistence.Repository.MudaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MudaService implements MudaCicloGateway {

    private final MudaRepository mudaRepository;
    private final MudaMapper mudaMapper;

    public MudaService(MudaRepository mudaRepository, MudaMapper mudaMapper) {
        this.mudaRepository = mudaRepository;
        this.mudaMapper = mudaMapper;
    }

    @Override
    public ResponseEntity<Muda> BuscarCorpoPorId(Long id)
    {
        try
        {
            if(id == null){throw new NullargumentsException();}
            MudaEntity entity = mudaRepository.findById(id).orElseThrow(
                    EntityNotFoundException::new
            );
            Muda response = mudaMapper.EntityToDto(entity);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Muda> NovoCiclo()
    {
        try
        {
            MudaEntity entity = new MudaEntity();
            entity.SetinfoInicial();
            mudaRepository.save(entity);
            Muda response = mudaMapper.EntityToDto(entity);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Muda> AtualizarEntidadeInicio(Long id)
    {
        try
        {
            if(id == null){throw new NullargumentsException();}
            Muda muda = BuscarCorpoPorId(id).getBody();
            MudaEntity entity = mudaMapper.DtoToEntity(muda);
            entity.Setdados();
            muda = mudaMapper.EntityToDto(entity);
            SalvarAlteracao(muda);
            return new ResponseEntity<>(muda, HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Muda> AtualizarEntidadeFim(Long id)
    {
        try
        {
            if(id == null){throw new NullargumentsException();}
            Muda muda = BuscarCorpoPorId(id).getBody();
            MudaEntity entity = mudaMapper.DtoToEntity(muda);
            entity.FimCiclo();
            muda = mudaMapper.EntityToDto(entity);
            SalvarAlteracao(muda);
            return new ResponseEntity<>(muda, HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Muda> SalvarAlteracao(Muda muda)
    {
        try
        {
            MudaEntity entity = mudaMapper.DtoToEntity(muda);
            mudaRepository.save(entity);
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
            Muda muda = BuscarCorpoPorId(id).getBody();
            mudaRepository.deleteById(muda.getId());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
