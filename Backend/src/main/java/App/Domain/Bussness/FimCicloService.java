package App.Domain.Bussness;

import App.Domain.Response.Ciclo;
import App.Domain.Response.Fim;
import App.Domain.Response.Floracao;
import App.Domain.Response.Localizacao;
import App.Infra.Exceptions.EntityNotFoundException;
import App.Infra.Exceptions.NullargumentsException;
import App.Infra.Gateway.FimCicloGateway;
import App.Infra.Mapper.FimCicloMapper;
import App.Infra.Persistence.Entity.FimEntity;
import App.Infra.Persistence.Entity.FloracaoEntity;
import App.Infra.Persistence.Repository.FimRepository;
import App.Infra.UseCase.Crecimento.UseCaseCrecimentoCicloPut;
import App.Infra.UseCase.FloracaoCiclo.UseCaseFloracaoCicloPut;
import App.Infra.UseCase.FrutificacaoCiclo.UseCaseFrutificacaoCicloPut;
import App.Infra.UseCase.GerminacaoCiclo.UseCaseGerminacaoCicloPut;
import App.Infra.UseCase.Localizacao.UseCaseLocalizacaoGet;
import App.Infra.UseCase.Localizacao.UseCaseLocalizacaoPut;
import App.Infra.UseCase.MaturacaoCiclo.UseCaseMaturacaoCicloPut;
import App.Infra.UseCase.MudaCiclo.UseCaseMudaCicloPut;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import static App.Infra.Persistence.Enum.CICLO.*;
import static App.Infra.Persistence.Enum.CICLO.MATURACAO;

@Service
public class FimCicloService implements FimCicloGateway {

    private final FimRepository fimRepository;
    private final FimCicloMapper fimCicloMapper;
    private final UseCaseLocalizacaoGet caseLocalizacaoGet;
    private final UseCaseLocalizacaoPut caseLocalizacaoPut;
    private final UseCaseGerminacaoCicloPut caseGerminacaoCicloPut;
    private final UseCaseMudaCicloPut caseMudaCicloPut;
    private final UseCaseCrecimentoCicloPut caseCrecimentoCicloPut;
    private final UseCaseFloracaoCicloPut caseFloracaoCicloPut;
    private final UseCaseFrutificacaoCicloPut caseFrutificacaoCicloPut;
    private final UseCaseMaturacaoCicloPut caseMaturacaoCicloPut;

    public FimCicloService(FimRepository fimRepository,
                           FimCicloMapper fimCicloMapper,
                           @Lazy UseCaseLocalizacaoGet caseLocalizacaoGet,
                           @Lazy UseCaseLocalizacaoPut caseLocalizacaoPut,
                           @Lazy UseCaseGerminacaoCicloPut caseGerminacaoCicloPut,
                           @Lazy UseCaseMudaCicloPut caseMudaCicloPut,
                           @Lazy UseCaseCrecimentoCicloPut caseCrecimentoCicloPut,
                           @Lazy UseCaseFloracaoCicloPut caseFloracaoCicloPut,
                           @Lazy UseCaseFrutificacaoCicloPut caseFrutificacaoCicloPut,
                           @Lazy UseCaseMaturacaoCicloPut caseMaturacaoCicloPut)
    {
        this.fimRepository = fimRepository;
        this.fimCicloMapper = fimCicloMapper;
        this.caseLocalizacaoGet = caseLocalizacaoGet;
        this.caseLocalizacaoPut = caseLocalizacaoPut;
        this.caseGerminacaoCicloPut = caseGerminacaoCicloPut;
        this.caseMudaCicloPut = caseMudaCicloPut;
        this.caseCrecimentoCicloPut = caseCrecimentoCicloPut;
        this.caseFloracaoCicloPut = caseFloracaoCicloPut;
        this.caseFrutificacaoCicloPut = caseFrutificacaoCicloPut;
        this.caseMaturacaoCicloPut = caseMaturacaoCicloPut;
    }

    @Override
    public ResponseEntity<Fim> BuscarCorpoPorId(Long id)
    {
        try
        {
            if(id == null){throw new NullargumentsException();}
            FimEntity entity = fimRepository.findById(id).orElseThrow(
                    EntityNotFoundException::new
            );
            Fim response = fimCicloMapper.EntityToDto(entity);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Fim> NovoCiclo()
    {
        try
        {
            FimEntity entity = new FimEntity();
            entity.Setinfo();
            fimRepository.save(entity);
            Fim response = fimCicloMapper.EntityToDto(entity);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Fim>AtualizarEntidade(Ciclo ciclo, String identificadorLocalizacao)
    {
        try
        {
            if(ciclo == null){throw new NullargumentsException();}
            if(identificadorLocalizacao == null){throw new NullargumentsException();}
            Fim fim = BuscarCorpoPorId(ciclo.getFim().getId()).getBody();
            Localizacao localizacao = caseLocalizacaoGet.BuscarLocalizacaoPorReferencia(identificadorLocalizacao).getBody();
            if(ciclo.getCiclo().equals(GERMINACAO))
            {
                caseGerminacaoCicloPut.AtualizarEntidadeFim(ciclo.getGerminacao().getId());
            }
            if(ciclo.getCiclo().equals(MUDA))
            {
                caseMudaCicloPut.AtualizarEntidadeFim(ciclo.getMuda().getId());
            }
            if(ciclo.getCiclo().equals(CRESCIMENTO))
            {
                caseCrecimentoCicloPut.AtualizarEntidadeFim(ciclo.getCrecimento().getId());
            }
            if(ciclo.getCiclo().equals(FLORACAO))
            {
                caseFloracaoCicloPut.AtualizarEntidadeFim(ciclo.getFloracao().getId());
            }
            if(ciclo.getCiclo().equals(FRUTIFICACAO))
            {
                caseFrutificacaoCicloPut.AtualizarEntidadeFim(ciclo.getFrutificacao().getId());
            }
            if(ciclo.getCiclo().equals(MATURACAO))
            {
                caseMaturacaoCicloPut.AtualizarEntidadeFim(ciclo.getMaturacao().getId());
            }
            caseLocalizacaoPut.DisponibilizarLocalizacao(localizacao.getId());
            FimEntity fimEntity = fimCicloMapper.DtoToEntity(fim);
            fimEntity.SetDados();
            fim = fimCicloMapper.EntityToDto(fimEntity);
            SalvarAlteracoes(fim);
            return new ResponseEntity<>(fim,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Fim> SalvarAlteracoes(Fim fim)
    {
        try
        {
            if(fim == null){throw new NullargumentsException();}
            FimEntity entity = fimCicloMapper.DtoToEntity(fim);
            fimRepository.save(entity);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Void>DeletarPorId(@RequestParam Long id)
    {
        try
        {
            if(id == null){throw new NullargumentsException();}
            Fim fim = BuscarCorpoPorId(id).getBody();
            fimRepository.deleteById(fim.getId());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
