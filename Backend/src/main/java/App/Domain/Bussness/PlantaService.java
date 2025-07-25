package App.Domain.Bussness;

import App.Domain.Response.*;
import App.Infra.Exceptions.EntityNotFoundException;
import App.Infra.Exceptions.IllegalActionException;
import App.Infra.Exceptions.NullargumentsException;
import App.Infra.Gateway.PlantaGateway;
import App.Infra.Mapper.*;
import App.Infra.Persistence.Entity.*;
import App.Infra.Persistence.Enum.CICLO;
import App.Infra.Persistence.Repository.PlantaRepository;
import App.Infra.UseCase.Ciclo.UseCaseCicloDelete;
import App.Infra.UseCase.Ciclo.UseCaseCicloGet;
import App.Infra.UseCase.Ciclo.UseCaseCicloPost;
import App.Infra.UseCase.Ciclo.UseCaseCicloPut;
import App.Infra.UseCase.Localizacao.UseCaseLocalizacaoGet;
import App.Infra.UseCase.Localizacao.UseCaseLocalizacaoPut;
import App.Infra.UseCase.Mensagem.UseCaseMensagemPost;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Blob;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static App.Infra.Persistence.Enum.CICLO.*;

@Service
public class PlantaService implements PlantaGateway {

    private final PlantaRepository plantaRepository;
    private final PlantaMapper plantaMapper;
    private final UseCaseCicloGet caseCicloGet;
    private final UseCaseCicloPost caseCicloPost;
    private final UseCaseCicloPut caseCicloPut;
    private final UseCaseCicloDelete caseCicloDelete;
    private final CicloMapper cicloMapper;
    private final UseCaseMensagemPost useCaseMensagemPost;
    private final UseCaseLocalizacaoGet useCaseLocalizacaoGet;
    private final UseCaseLocalizacaoPut useCaseLocalizacaoPut;

    public PlantaService(PlantaRepository plantaRepository,
                         PlantaMapper plantaMapper,
                         @Lazy UseCaseCicloGet caseCicloGet,
                         @Lazy UseCaseCicloPost caseCicloPost,
                         @Lazy UseCaseCicloPut caseCicloPut,
                         @Lazy UseCaseCicloDelete caseCicloDelete,
                         CicloMapper cicloMapper,
                         @Lazy UseCaseMensagemPost useCaseMensagemPost,
                         @Lazy UseCaseLocalizacaoGet useCaseLocalizacaoGet,
                         @Lazy UseCaseLocalizacaoPut useCaseLocalizacaoPut)
    {
        this.plantaRepository = plantaRepository;
        this.plantaMapper = plantaMapper;
        this.caseCicloGet = caseCicloGet;
        this.caseCicloPost = caseCicloPost;
        this.caseCicloPut = caseCicloPut;
        this.caseCicloDelete = caseCicloDelete;
        this.cicloMapper = cicloMapper;
        this.useCaseMensagemPost = useCaseMensagemPost;
        this.useCaseLocalizacaoGet = useCaseLocalizacaoGet;
        this.useCaseLocalizacaoPut = useCaseLocalizacaoPut;
    }


    @Override
    public ResponseEntity<List<Planta>> ListarPlantas()
    {
        try
        {
            List<PlantaEntity> plantaEntities = plantaRepository.findAll();
            List<Planta> response = new ArrayList<>();
            for(PlantaEntity entity : plantaEntities)
            {
                Planta dto = plantaMapper.EntityToDto(entity);
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
    public ResponseEntity<List<Planta>> ListarPlantasGerminacao()
        {
            try
            {
                List<PlantaEntity> plantaEntities = plantaRepository.findAll();
                List<Planta> response = new ArrayList<>();
                for(PlantaEntity entity : plantaEntities)
                {
                    if (entity.getCiclo().getCiclo().equals(GERMINACAO))
                    {
                        Planta dto = plantaMapper.EntityToDto(entity);
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
    public ResponseEntity<List<Planta>> ListarPlantasMuda()
    {
        try
        {
            List<PlantaEntity> plantaEntities = plantaRepository.findAll();
            List<Planta> response = new ArrayList<>();
            for(PlantaEntity entity : plantaEntities)
            {
                if (entity.getCiclo().getCiclo().equals(MUDA))
                {
                    Planta dto = plantaMapper.EntityToDto(entity);
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
    public ResponseEntity<List<Planta>> ListarPlantasCrescimento()
    {
        try
        {
            List<PlantaEntity> plantaEntities = plantaRepository.findAll();
            List<Planta> response = new ArrayList<>();
            for(PlantaEntity entity : plantaEntities)
            {
                if (entity.getCiclo().getCiclo().equals(CRESCIMENTO))
                {
                    Planta dto = plantaMapper.EntityToDto(entity);
                    response.add(dto);
                }
            }
            return new ResponseEntity<>(response,HttpStatus.OK);
        } catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<List<Planta>> ListarPlantasFloracao()
    {
        try
        {
            List<PlantaEntity> plantaEntities = plantaRepository.findAll();
            List<Planta> response = new ArrayList<>();
            for(PlantaEntity entity : plantaEntities)
            {
                if (entity.getCiclo().getCiclo().equals(FLORACAO))
                {
                    Planta dto = plantaMapper.EntityToDto(entity);
                    response.add(dto);
                }
            }
            return new ResponseEntity<>(response,HttpStatus.OK);
        } catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<List<Planta>> ListarPlantasFrutificacao()
    {
        try
        {
            List<PlantaEntity> plantaEntities = plantaRepository.findAll();
            List<Planta> response = new ArrayList<>();
            for(PlantaEntity entity : plantaEntities)
            {
                if (entity.getCiclo().getCiclo().equals(FRUTIFICACAO))
                {
                    Planta dto = plantaMapper.EntityToDto(entity);
                    response.add(dto);
                }
            }
            return new ResponseEntity<>(response,HttpStatus.OK);
        } catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<List<Planta>> ListarPlantasMaturacao()
    {
        try
        {
            List<PlantaEntity> plantaEntities = plantaRepository.findAll();
            List<Planta> response = new ArrayList<>();
            for(PlantaEntity entity : plantaEntities)
            {
                if (entity.getCiclo().getCiclo().equals(MATURACAO))
                {
                    Planta dto = plantaMapper.EntityToDto(entity);
                    response.add(dto);
                }
            }
            return new ResponseEntity<>(response,HttpStatus.OK);
        } catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<List<Planta>> ListarPlantasFimCiclo()
    {
        try
        {
            List<PlantaEntity> plantaEntities = plantaRepository.findAll();
            List<Planta> response = new ArrayList<>();
            for(PlantaEntity entity : plantaEntities)
            {
                if (entity.getCiclo().getCiclo().equals(FIM))
                {
                    Planta dto = plantaMapper.EntityToDto(entity);
                    response.add(dto);
                }
            }
            return new ResponseEntity<>(response,HttpStatus.OK);
        } catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Planta> BuscarPlantaPorId(Long id)
    {
        try
        {
            if(id == null) {throw new NullargumentsException();}
            PlantaEntity entity = plantaRepository.findById(id).orElseThrow(
                    EntityNotFoundException::new
            );
            Planta response = plantaMapper.EntityToDto(entity);
            return new ResponseEntity<>(response,HttpStatus.OK);
        } catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }



    @Override
    public ResponseEntity<Planta> NovaPlanta(Long localizacaoId, String nomeCientifico, String nomePopular, String instrucoes)
    {
        try
        {
            if(nomeCientifico == null){throw new NullargumentsException();}
            if(nomePopular == null){throw new NullargumentsException();}
            if(instrucoes == null){throw new NullargumentsException();}
            if(localizacaoId == null){throw new NullargumentsException();}
            Localizacao localizacao = useCaseLocalizacaoGet.BuscarLocalizacaoPorId(localizacaoId).getBody();
            PlantaEntity entity = new PlantaEntity();
            Ciclo ciclo = caseCicloPost.NovoCiclo().getBody();
            caseCicloPut.AlterarCiclo(ciclo.getId(),CICLO.GERMINACAO);
            CicloEntity cicloEntity = cicloMapper.DtoToEntity(ciclo);
            entity.SetInfo(nomePopular,nomeCientifico,instrucoes,localizacao.getReferencia(),cicloEntity);
            plantaRepository.save(entity);
            Planta response = plantaMapper.EntityToDto(entity);
            useCaseLocalizacaoPut.IndisponibilizarLocalizacao(localizacao.getId(),response);
            String identificadorPlantio = useCaseMensagemPost.setIdentificadorPlantio(localizacao.getReferencia());
            String mensagem = "Na data de "+LocalDateTime.now()+" Houve uma nova planta, de nome cientifico: "+response.getNomeCientifico()+" e nome popular: "+response.getNomePopular()+".";
            useCaseMensagemPost.SetMensangem(identificadorPlantio,mensagem);
            return  new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Planta> EditarPlanta(Long plantaId, String nomeCientifico, String nomePopular,String instrucoes)
    {
        try
        {
            if(plantaId == null){throw new NullargumentsException();}
            if(nomeCientifico == null){throw new NullargumentsException();}
            if(nomePopular == null){throw new NullargumentsException();}
            if(instrucoes == null){throw new NullargumentsException();}
            Planta planta = BuscarPlantaPorId(plantaId).getBody();
            String nomePopularAnterior = planta.getNomePopular();
            PlantaEntity entity = plantaMapper.DtoToEntity(planta);
            entity.EditInfo(nomePopular,nomeCientifico,instrucoes);
            planta = plantaMapper.EntityToDto(entity);
            SalvarAlteracao(planta);
            String identificadorPlantio = useCaseMensagemPost.setIdentificadorPlantio(planta.getLocalizacao());
            String mensagem = "Na data de "+LocalDateTime.now()+" Houve uma alteração nos dados cadastrais na planta "+nomePopular+".";
            if(!nomePopularAnterior.equals(nomePopular))
            {
                mensagem = "Na data de "+LocalDateTime.now()+" Houve uma alteração nos dados cadastrais na planta "+nomePopularAnterior+" ,que agora se identifica por "+nomePopular+".";
            }
            useCaseMensagemPost.SetMensangem(identificadorPlantio,mensagem);
            return new ResponseEntity<>(planta, HttpStatus.OK);
        } catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Planta> AlterarCiclo(Long id, String ciclo)
    {
        try
        {
            if(id != null)
            {
                Planta planta = BuscarPlantaPorId(id).getBody();
                PlantaEntity entity = plantaMapper.DtoToEntity(planta);
                CICLO cicloConvertido = RetornaCicloAtual(ciclo);
                caseCicloPut.AlterarCiclo(planta.getId(), cicloConvertido);
                Planta response = plantaMapper.EntityToDto(entity);
                SalvarAlteracao(response);
                String identificadorPlantio = useCaseMensagemPost.setIdentificadorPlantio(planta.getLocalizacao());
                String mensagem = "Na data de "+LocalDateTime.now()+" Houve uma alteração de Ciclo na planta "+planta.getNomePopular()+", estando agora no ciclo "+ciclo+".";
                useCaseMensagemPost.SetMensangem(identificadorPlantio,mensagem);
                return new ResponseEntity<>(response,HttpStatus.OK);
            }
            else {throw new NullargumentsException();}
        } catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public CICLO RetornaCicloAtual(String ciclo)
    {
        try
        {
            if(ciclo.equals("GERMINACAO"))
            { return GERMINACAO;}
            if(ciclo.equals("MUDA"))
            { return MUDA;}
            if(ciclo.equals("CRESCIMENTO"))
            { return CRESCIMENTO;}
            if(ciclo.equals("FLORACAO"))
            { return FLORACAO;}
            if(ciclo.equals("FRUTIFICACAO"))
            { return FRUTIFICACAO;}
            if(ciclo.equals("MATURACAO"))
            { return MATURACAO;}
            if(ciclo.equals("FIM"))
            { return FIM;}
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return null;
    }

    public ResponseEntity<Void> SalvarAlteracao(Planta planta)
    {
        try
        {
            if(planta == null){throw new NullargumentsException();}
            PlantaEntity entity = plantaMapper.DtoToEntity(planta);
            plantaRepository.save(entity);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Planta> AtualizarLocalizacao(Long plantaId, String referenciaLocalizacao)
    {
        try
        {
            if(plantaId == null){throw new NullargumentsException();}
            if(referenciaLocalizacao == null){throw new NullargumentsException();}
            Planta planta = BuscarPlantaPorId(plantaId).getBody();
            PlantaEntity entity = plantaMapper.DtoToEntity(planta);
            entity.AlterarLocalizacao(referenciaLocalizacao);
            planta = plantaMapper.EntityToDto(entity);
            SalvarAlteracao(planta);
            return new ResponseEntity<>(planta, HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Planta> AlterarLocalizacao(Long plantaId, Long localizacaoId)
    {
        try
        {
            if(plantaId == null){throw new NullargumentsException();}
            Planta planta = BuscarPlantaPorId(plantaId).getBody();
            if(planta.getLocalizacao() == null){throw new IllegalActionException();}
            Localizacao localizacao = useCaseLocalizacaoGet.BuscarLocalizacaoPorReferencia(planta.getLocalizacao()).getBody();
            String localizacaoAnterior = localizacao.getReferencia();
            useCaseLocalizacaoPut.DisponibilizarLocalizacao(localizacao.getId());
            Localizacao localizacaoAtual = useCaseLocalizacaoGet.BuscarLocalizacaoPorId(localizacaoId).getBody();
            PlantaEntity entity = plantaMapper.DtoToEntity(planta);
            entity.AlterarLocalizacao(localizacaoAtual.getReferencia());
            planta = plantaMapper.EntityToDto(entity);
            SalvarAlteracao(planta);
            useCaseLocalizacaoPut.IndisponibilizarLocalizacao(localizacaoAtual.getId(),planta);
            String identificadorPlantio = useCaseMensagemPost.setIdentificadorPlantio(planta.getLocalizacao());
            String mensagem = "Na data de "+LocalDateTime.now()+" Houve uma alteração de Localização na planta "+planta.getNomePopular()+", que se encontrava em "+localizacaoAnterior+" estando agora na localização: "+localizacaoAtual.getReferencia()+".";
            useCaseMensagemPost.SetMensangem(identificadorPlantio,mensagem);
            return new ResponseEntity<>(planta, HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Void> DeletarPlantaPorId(Long id)
    {
        try
        {
            if(id == null){throw new NullargumentsException();}
            Planta planta = BuscarPlantaPorId(id).getBody();
            Ciclo ciclo = caseCicloGet.BuscarCicloPorId(planta.getCiclo().getId()).getBody();
            PlantaEntity entity = plantaMapper.DtoToEntity(planta);
            entity.ResetEntity();
            planta = plantaMapper.EntityToDto(entity);
            SalvarAlteracao(planta);
            caseCicloDelete.DeletarPorId(ciclo.getId());
            plantaRepository.deleteById(planta.getId());
            String identificadorPlantio = useCaseMensagemPost.setIdentificadorPlantio(planta.getLocalizacao());
            String mensagem = "Na data de "+LocalDateTime.now()+" a planta "+planta.getNomePopular()+", foi deletada.";
            useCaseMensagemPost.SetMensangem(identificadorPlantio,mensagem);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
