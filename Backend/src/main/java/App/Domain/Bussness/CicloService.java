package App.Domain.Bussness;

import App.Domain.Response.*;
import App.Infra.Exceptions.EntityNotFoundException;
import App.Infra.Exceptions.IllegalActionException;
import App.Infra.Exceptions.NullargumentsException;
import App.Infra.Gateway.CicloGateway;
import App.Infra.Mapper.*;
import App.Infra.Persistence.Entity.*;
import App.Infra.Persistence.Enum.CICLO;
import App.Infra.Persistence.Repository.CicloRepository;
import App.Infra.UseCase.Crecimento.UseCaseCrecimentoCicloDelete;
import App.Infra.UseCase.Crecimento.UseCaseCrecimentoCicloPost;
import App.Infra.UseCase.Crecimento.UseCaseCrecimentoCicloPut;
import App.Infra.UseCase.FimCiclo.UseCaseFimCicloDelete;
import App.Infra.UseCase.FimCiclo.UseCaseFimCicloPost;
import App.Infra.UseCase.FimCiclo.UseCaseFimCicloPut;
import App.Infra.UseCase.FloracaoCiclo.UseCaseFloracaoCicloDelete;
import App.Infra.UseCase.FloracaoCiclo.UseCaseFloracaoCicloPost;
import App.Infra.UseCase.FloracaoCiclo.UseCaseFloracaoCicloPut;
import App.Infra.UseCase.FrutificacaoCiclo.UseCaseFrutificacaoCicloDelete;
import App.Infra.UseCase.FrutificacaoCiclo.UseCaseFrutificacaoCicloPost;
import App.Infra.UseCase.FrutificacaoCiclo.UseCaseFrutificacaoCicloPut;
import App.Infra.UseCase.GerminacaoCiclo.UseCaseGerminacaoCicloDelete;
import App.Infra.UseCase.GerminacaoCiclo.UseCaseGerminacaoCicloPost;
import App.Infra.UseCase.GerminacaoCiclo.UseCaseGerminacaoCicloPut;
import App.Infra.UseCase.MaturacaoCiclo.UseCaseMaturacaoCicloDelete;
import App.Infra.UseCase.MaturacaoCiclo.UseCaseMaturacaoCicloPost;
import App.Infra.UseCase.MaturacaoCiclo.UseCaseMaturacaoCicloPut;
import App.Infra.UseCase.MudaCiclo.UseCaseMudaCicloDelete;
import App.Infra.UseCase.MudaCiclo.UseCaseMudaCicloPost;
import App.Infra.UseCase.MudaCiclo.UseCaseMudaCicloPut;
import App.Infra.UseCase.Planta.UseCasePlantaGet;
import App.Infra.UseCase.Plantio.UseCasePlantioGet;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static App.Infra.Persistence.Enum.CICLO.*;

@Service
public class CicloService implements CicloGateway {

    private final CicloRepository cicloRepository;
    private final CicloMapper cicloMapper;
    private final UseCasePlantaGet casePlantaGet;
    private final UseCaseGerminacaoCicloPost caseGerminacaoCicloPost;
    private final UseCaseMudaCicloPost caseMudaCicloPost;
    private final UseCaseCrecimentoCicloPost caseCrecimentoCicloPost;
    private final UseCaseFloracaoCicloPost caseFloracaoCicloPost;
    private final UseCaseFrutificacaoCicloPost caseFrutificacaoCicloPost;
    private final UseCaseMaturacaoCicloPost caseMaturacaoCicloPost;
    private final UseCaseFimCicloPost caseFimCicloPost;
    private final UseCaseGerminacaoCicloPut caseGerminacaoCicloPut;
    private final UseCaseMudaCicloPut caseMudaCicloPut;
    private final UseCaseCrecimentoCicloPut caseCrecimentoCicloPut;
    private final UseCaseFloracaoCicloPut caseFloracaoCicloPut;
    private final UseCaseFrutificacaoCicloPut caseFrutificacaoCicloPut;
    private final UseCaseMaturacaoCicloPut caseMaturacaoCicloPut;
    private final UseCaseFimCicloPut caseFimCicloPut;
    private final UseCaseGerminacaoCicloDelete caseGerminacaoCicloDelete;
    private final UseCaseMudaCicloDelete caseMudaCicloDelete;
    private final UseCaseCrecimentoCicloDelete caseCrecimentoCicloDelete;
    private final UseCaseFloracaoCicloDelete caseFloracaoCicloDelete;
    private final UseCaseFrutificacaoCicloDelete caseFrutificacaoCicloDelete;
    private final UseCaseMaturacaoCicloDelete caseMaturacaoCicloDelete;
    private final UseCaseFimCicloDelete caseFimCicloDelete;
    private final GerminacaoMapper germinacaoMapper;
    private final MudaMapper mudaMapper;
    private final CrecimentoMapper crecimentoMapper;
    private final FloracaoMapper floracaoMapper;
    private final FrutificacaoMapper frutificacaoMapper;
    private final MaturacaoMapper maturacaoMapper;
    private final FimCicloMapper fimCicloMapper;

    public CicloService(CicloRepository cicloRepository,
                        CicloMapper cicloMapper,
                        @Lazy UseCasePlantaGet casePlantaGet,
                        @Lazy UseCaseGerminacaoCicloPost caseGerminacaoCicloPost,
                        @Lazy UseCaseMudaCicloPost caseMudaCicloPost,
                        @Lazy UseCaseCrecimentoCicloPost caseCrecimentoCicloPost,
                        @Lazy UseCaseFloracaoCicloPost caseFloracaoCicloPost,
                        @Lazy UseCaseFrutificacaoCicloPost caseFrutificacaoCicloPost,
                        @Lazy UseCaseMaturacaoCicloPost caseMaturacaoCicloPost,
                        @Lazy UseCaseFimCicloPost caseFimCicloPost,
                        @Lazy UseCaseMudaCicloPut caseMudaCicloPut,
                        @Lazy UseCaseCrecimentoCicloPut caseCrecimentoCicloPut,
                        @Lazy UseCaseGerminacaoCicloPut caseGerminacaoCicloPut,
                        @Lazy UseCaseFloracaoCicloPut caseFloracaoCicloPut,
                        @Lazy UseCaseFrutificacaoCicloPut caseFrutificacaoCicloPut,
                        @Lazy UseCaseMaturacaoCicloPut caseMaturacaoCicloPut,
                        @Lazy UseCaseFimCicloPut caseFimCicloPut,
                        @Lazy UseCaseGerminacaoCicloDelete caseGerminacaoCicloDelete,
                        @Lazy UseCaseMudaCicloDelete caseMudaCicloDelete,
                        @Lazy UseCaseCrecimentoCicloDelete caseCrecimentoCicloDelete,
                        @Lazy UseCaseFloracaoCicloDelete caseFloracaoCicloDelete,
                        @Lazy UseCaseFrutificacaoCicloDelete caseFrutificacaoCicloDelete,
                        @Lazy UseCaseMaturacaoCicloDelete caseMaturacaoCicloDelete,
                        @Lazy UseCaseFimCicloDelete caseFimCicloDelete,
                        GerminacaoMapper germinacaoMapper,
                        MudaMapper mudaMapper,
                        CrecimentoMapper crecimentoMapper,
                        FloracaoMapper floracaoMapper,
                        FrutificacaoMapper frutificacaoMapper,
                        MaturacaoMapper maturacaoMapper,
                        FimCicloMapper fimCicloMapper) {
        this.cicloRepository = cicloRepository;
        this.cicloMapper = cicloMapper;
        this.casePlantaGet = casePlantaGet;
        this.caseGerminacaoCicloPost = caseGerminacaoCicloPost;
        this.caseMudaCicloPost = caseMudaCicloPost;
        this.caseCrecimentoCicloPost = caseCrecimentoCicloPost;
        this.caseFloracaoCicloPost = caseFloracaoCicloPost;
        this.caseFrutificacaoCicloPost = caseFrutificacaoCicloPost;
        this.caseMaturacaoCicloPost = caseMaturacaoCicloPost;
        this.caseFimCicloPost = caseFimCicloPost;
        this.caseMudaCicloPut = caseMudaCicloPut;
        this.caseCrecimentoCicloPut = caseCrecimentoCicloPut;
        this.caseGerminacaoCicloPut = caseGerminacaoCicloPut;
        this.caseFloracaoCicloPut = caseFloracaoCicloPut;
        this.caseFrutificacaoCicloPut = caseFrutificacaoCicloPut;
        this.caseMaturacaoCicloPut = caseMaturacaoCicloPut;
        this.caseFimCicloPut = caseFimCicloPut;
        this.caseGerminacaoCicloDelete = caseGerminacaoCicloDelete;
        this.caseMudaCicloDelete = caseMudaCicloDelete;
        this.caseCrecimentoCicloDelete = caseCrecimentoCicloDelete;
        this.caseFloracaoCicloDelete = caseFloracaoCicloDelete;
        this.caseFrutificacaoCicloDelete = caseFrutificacaoCicloDelete;
        this.caseMaturacaoCicloDelete = caseMaturacaoCicloDelete;
        this.caseFimCicloDelete = caseFimCicloDelete;
        this.germinacaoMapper = germinacaoMapper;
        this.mudaMapper = mudaMapper;
        this.crecimentoMapper = crecimentoMapper;
        this.floracaoMapper = floracaoMapper;
        this.frutificacaoMapper = frutificacaoMapper;
        this.maturacaoMapper = maturacaoMapper;
        this.fimCicloMapper = fimCicloMapper;
    }


    @Override
    public ResponseEntity<Ciclo> BuscarCicloPorId(Long id)
    {
        try
        {
            if(id == null){throw new NullargumentsException();}
            CicloEntity entity = cicloRepository.findById(id).orElseThrow(
                    EntityNotFoundException::new
            );
            Ciclo response = cicloMapper.EntityToDto(entity);
            return new ResponseEntity<>(response,HttpStatus.OK);
        } catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Ciclo> NovoCiclo()
    {
        try
        {
            CicloEntity entity = new CicloEntity();
            Germinacao germinacao = caseGerminacaoCicloPost.NovoCiclo().getBody();
            Muda muda = caseMudaCicloPost.NovoCiclo().getBody();
            Crecimento crecimento = caseCrecimentoCicloPost.NovoCiclo().getBody();
            Floracao floracao = caseFloracaoCicloPost.NovoCiclo().getBody();
            Frutificacao frutificacao = caseFrutificacaoCicloPost.NovoCiclo().getBody();
            Maturacao maturacao = caseMaturacaoCicloPost.NovoCiclo().getBody();
            Fim fim = caseFimCicloPost.NovoCiclo().getBody();
            GerminacaoEntity germinacaoEntity = germinacaoMapper.DtoToEntity(germinacao);
            MudaEntity mudaEntity = mudaMapper.DtoToEntity(muda);
            CrecimentoEntity crecimentoEntity = crecimentoMapper.DtoToEntity(crecimento);
            FloracaoEntity floracaoEntity = floracaoMapper.DtoToEntity(floracao);
            FrutificacaoEntity frutificacaoEntity = frutificacaoMapper.DtoToEntity(frutificacao);
            MaturacaoEntity maturacaoEntity = maturacaoMapper.DtoToEntity(maturacao);
            FimEntity fimEntity = fimCicloMapper.DtoToEntity(fim);
            entity.SetInfo(germinacaoEntity,mudaEntity,crecimentoEntity,floracaoEntity,frutificacaoEntity,maturacaoEntity,fimEntity);
            cicloRepository.save(entity);
            Ciclo response = cicloMapper.EntityToDto(entity);
            return new ResponseEntity<>(response,HttpStatus.CREATED);
        } catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Ciclo> AlterarCiclo(Long plantaId,CICLO ciclo)
    {
        try
        {
            if(plantaId == null){throw new NullargumentsException();}
            if(ciclo == null){throw new NullargumentsException();}
            Planta planta = casePlantaGet.BuscarPlantaPorId(plantaId).getBody();
            Ciclo cicloBody = BuscarCicloPorId(planta.getCiclo().getId()).getBody();
            CicloEntity entity = cicloMapper.DtoToEntity(cicloBody);
            Boolean valida = entity.ValidaCiclo(ciclo);
            if(valida.equals(Boolean.FALSE)){throw new IllegalActionException();}
            if(ciclo.equals(MUDA))
            {
              caseGerminacaoCicloPut.AtualizarEntidadeFim(entity.getGerminacao().getId());
              caseMudaCicloPut.AtualizarEntidadeInicio(entity.getMuda().getId());
            }
            if(ciclo.equals(CRESCIMENTO))
            {
                caseMudaCicloPut.AtualizarEntidadeFim(entity.getMuda().getId());
                caseCrecimentoCicloPut.AtualizarEntidadeInicio(entity.getCrecimento().getId());
            }
            if(ciclo.equals(FLORACAO))
            {
              caseCrecimentoCicloPut.AtualizarEntidadeFim(entity.getCrecimento().getId());
              caseFloracaoCicloPut.AtualizarEntidadeInicio(entity.getFloracao().getId());
            }
            if(ciclo.equals(FRUTIFICACAO))
            {
              caseFloracaoCicloPut.AtualizarEntidadeFim(entity.getFloracao().getId());
              caseFrutificacaoCicloPut.AtualizarEntidadeInicio(entity.getFrutificacao().getId());
            }
            if(ciclo.equals(MATURACAO))
            {
                caseFrutificacaoCicloPut.AtualizarEntidadeFim(entity.getFrutificacao().getId());
                caseMaturacaoCicloPut.AtualizarEntidadeInicio(entity.getMaturacao().getId());
            }
            if(ciclo.equals(FIM))
            {
                caseFimCicloPut.AtualizarEntidade(cicloBody,planta.getLocalizacao());
            }
            entity.SetNovoCiclo(ciclo);
            cicloRepository.save(entity);
            Ciclo response = cicloMapper.EntityToDto(entity);
            return new ResponseEntity<>(response,HttpStatus.OK);
        } catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Ciclo> SalvarAlteracao(Ciclo ciclo)
    {
        try
        {
            if(ciclo != null)
            {
                CicloEntity entity = cicloMapper.DtoToEntity(ciclo);
                cicloRepository.save(entity);
                Ciclo response = cicloMapper.EntityToDto(entity);
                return new ResponseEntity<>(response,HttpStatus.OK);
            }
            else {throw new NullargumentsException();}
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Void> DeletarPorId(Long cicloId)
    {
        try
        {
            if(cicloId == null){throw new NullargumentsException();}
            Ciclo ciclo = BuscarCicloPorId(cicloId).getBody();
            CicloEntity entity = cicloMapper.DtoToEntity(ciclo);
            Long germinacaoCicloId = ciclo.getGerminacao().getId();
            Long mudaCicloId = ciclo.getMuda().getId();
            Long crecimentoCicloId = ciclo.getCrecimento().getId();
            Long floracaoCicloId = ciclo.getFloracao().getId();
            Long frutificacaoCicloId = ciclo.getFrutificacao().getId();
            Long maturacaoCicloId = ciclo.getMaturacao().getId();
            Long fimCicloId = ciclo.getFim().getId();
            //resetar entidade
            entity.ResetEntity();
            //salvar
            ciclo = cicloMapper.EntityToDto(entity);
            SalvarAlteracao(ciclo);
            //chamar os case delete dos ciclos
            caseGerminacaoCicloDelete.DeletarPorId(germinacaoCicloId);
            caseMudaCicloDelete.DeletarPorId(mudaCicloId);
            caseCrecimentoCicloDelete.DeletarPorId(crecimentoCicloId);
            caseFloracaoCicloDelete.DeletarPorId(floracaoCicloId);
            caseFrutificacaoCicloDelete.DeletarPorId(frutificacaoCicloId);
            caseMaturacaoCicloDelete.DeletarPorId(maturacaoCicloId);
            caseFimCicloDelete.DeletarPorId(fimCicloId);
            //deletar corpo
            cicloRepository.deleteById(ciclo.getId());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
