package App.Domain.Bussness;

import App.Domain.Response.Germinacao;
import App.Domain.Response.Maturacao;
import App.Infra.Exceptions.EntityNotFoundException;
import App.Infra.Exceptions.NullargumentsException;
import App.Infra.Gateway.MaturacaoCicloGateway;
import App.Infra.Mapper.GerminacaoMapper;
import App.Infra.Mapper.MaturacaoMapper;
import App.Infra.Persistence.Entity.GerminacaoEntity;
import App.Infra.Persistence.Entity.MaturacaoEntity;
import App.Infra.Persistence.Repository.GerminacaoRepository;
import App.Infra.Persistence.Repository.MaturacaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MaturacaoService implements MaturacaoCicloGateway {


    private final MaturacaoRepository maturacaoRepository;
    private final MaturacaoMapper maturacaoMapper;

    public MaturacaoService(MaturacaoRepository maturacaoRepository, MaturacaoMapper maturacaoMapper) {
        this.maturacaoRepository = maturacaoRepository;
        this.maturacaoMapper = maturacaoMapper;
    }

    @Override
    public ResponseEntity<Maturacao> BuscarCorpoPorId(Long id)
    {
        try
        {
            if(id == null){throw new NullargumentsException();}
            MaturacaoEntity entity = maturacaoRepository.findById(id).orElseThrow(
                    EntityNotFoundException::new
            );
            Maturacao response = maturacaoMapper.EntityToDto(entity);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Maturacao> NovoCiclo()
    {
        try
        {
            MaturacaoEntity entity = new MaturacaoEntity();
            entity.SetinfoInicial();
            maturacaoRepository.save(entity);
            Maturacao response = maturacaoMapper.EntityToDto(entity);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Maturacao> AtualizarEntidadeInicio(Long id)
    {
        try
        {
            if(id == null){throw new NullargumentsException();}
            Maturacao maturacao = BuscarCorpoPorId(id).getBody();
            MaturacaoEntity entity = maturacaoMapper.DtoToEntity(maturacao);
            entity.Setdados();
            maturacao = maturacaoMapper.EntityToDto(entity);
            SalvarAlteracao(maturacao);
            return new ResponseEntity<>(maturacao, HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Maturacao> AtualizarEntidadeFim(Long id)
    {
        try
        {
            if(id == null){throw new NullargumentsException();}
            Maturacao maturacao = BuscarCorpoPorId(id).getBody();
            MaturacaoEntity entity = maturacaoMapper.DtoToEntity(maturacao);
            entity.FimCiclo();
            maturacao = maturacaoMapper.EntityToDto(entity);
            SalvarAlteracao(maturacao);
            return new ResponseEntity<>(maturacao, HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Maturacao> SalvarAlteracao(Maturacao maturacao)
    {
        try
        {
            if(maturacao == null){throw new NullargumentsException();}
            MaturacaoEntity entity = maturacaoMapper.DtoToEntity(maturacao);
            maturacaoRepository.save(entity);
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
            Maturacao maturacao = BuscarCorpoPorId(id).getBody();
            maturacaoRepository.deleteById(maturacao.getId());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
