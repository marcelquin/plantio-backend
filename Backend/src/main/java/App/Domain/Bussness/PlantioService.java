package App.Domain.Bussness;

import App.Domain.Response.Area;
import App.Domain.Response.Linha;
import App.Domain.Response.Plantio;
import App.Infra.Exceptions.EntityNotFoundException;
import App.Infra.Exceptions.NullargumentsException;
import App.Infra.Gateway.AreaGateway;
import App.Infra.Gateway.PlantioGateway;
import App.Infra.Mapper.AreaMapper;
import App.Infra.Mapper.LinhaMapper;
import App.Infra.Mapper.PlantioMapper;
import App.Infra.Persistence.Entity.AreaEntity;
import App.Infra.Persistence.Entity.LinhaEntity;
import App.Infra.Persistence.Entity.PlantioEntity;
import App.Infra.Persistence.Repository.PlantioRepository;
import App.Infra.UseCase.Area.UseCaseAreaDelete;
import App.Infra.UseCase.Area.UseCaseAreaGet;
import App.Infra.UseCase.Area.UseCaseAreaPut;
import App.Infra.UseCase.Linha.UseCaseLinhaDelete;
import App.Infra.UseCase.Linha.UseCaseLinhaPut;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlantioService implements PlantioGateway {

    private final PlantioRepository plantioRepository;
    private final PlantioMapper plantioMapper;
    private final UseCaseAreaGet useCaseAreaGet;
    private final UseCaseAreaPut useCaseAreaPut;
    private final UseCaseLinhaPut caseLinhaPut;
    private final UseCaseLinhaDelete useCaseLinhaDelete;

    public PlantioService(PlantioRepository plantioRepository, PlantioMapper plantioMapper, @Lazy UseCaseAreaGet useCaseAreaGet, @Lazy UseCaseAreaPut useCaseAreaPut, UseCaseLinhaPut caseLinhaPut, @Lazy UseCaseLinhaDelete useCaseLinhaDelete) {
        this.plantioRepository = plantioRepository;
        this.plantioMapper = plantioMapper;
        this.useCaseAreaGet = useCaseAreaGet;
        this.useCaseAreaPut = useCaseAreaPut;
        this.caseLinhaPut = caseLinhaPut;
        this.useCaseLinhaDelete = useCaseLinhaDelete;
    }


    @Override
    public ResponseEntity<List<Plantio>> ListarPlantio()
    {
        try
        {
            List<PlantioEntity> entities = plantioRepository.findAll();
            List<Plantio> response = new ArrayList<>();
            for(PlantioEntity entity : entities)
            {
                    Plantio dto = plantioMapper.EntityToDto(entity);
                    response.add(dto);
            }
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Plantio> BuscarPlantioPorId(Long id)
    {
        try
        {
            if(id == null){throw new NullargumentsException();}
            PlantioEntity entity = plantioRepository.findById(id).orElseThrow(
                    EntityNotFoundException::new
            );
            Plantio response = plantioMapper.EntityToDto(entity);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Plantio> BuscarPlantioPorIdentificador(String identificador)
    {
        try
        {
            if(identificador == null){throw new NullargumentsException();}
            PlantioEntity entity = plantioRepository.findByidentificador(identificador).orElseThrow(
                    EntityNotFoundException::new
            );
            Plantio response = plantioMapper.EntityToDto(entity);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @Override
    public ResponseEntity<Plantio> NovoPlantio(Long areaId)
    {
        try
        {
            if(areaId == null){throw new NullargumentsException();}
            Area area = useCaseAreaGet.BuscarAreaPorId(areaId).getBody();
            PlantioEntity entity = new PlantioEntity();
            int numeroPlantio = area.getPlantios().size() + 1;
            entity.SetInfoInicial(area.getNome(), numeroPlantio);
            plantioRepository.save(entity);
            Plantio response = plantioMapper.EntityToDto(entity);
            area.getPlantios().add(response);
            useCaseAreaPut.SalvarAlteracoes(area);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> DeletarPlantioPorId(Long plantioId)
    {
        try
        {
            if(plantioId == null) {throw new NullargumentsException();}
            Plantio plantio = BuscarPlantioPorId(plantioId).getBody();
            String original = plantio.getIdentificador();
            String[] partes = original.split("_");
            String areaIdentificador = partes[0];
            Area area = useCaseAreaGet.BuscarAreaPorNome(areaIdentificador).getBody();
            List<Plantio> plantioList = new ArrayList<>();
            for(Plantio plantioInterno : area.getPlantios())
            {
                if(plantioInterno.getId() != plantio.getId())
                {
                    plantioList.add(plantioInterno);
                }
            }
            area.setPlantios(plantioList);
            useCaseAreaPut.SalvarAlteracoes(area);
            for(Linha linha : plantio.getLinhas())
            {
                useCaseLinhaDelete.DeletarLinhaPorId(linha.getId());
            }
            plantioRepository.deleteById(plantio.getId());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Plantio> AlterarIdentificador(Long id, String areaNome)
    {
        try
        {
            if(id == null){throw new NullargumentsException();}
            if(areaNome == null){throw new NullargumentsException();}
            Plantio plantio = BuscarPlantioPorId(id).getBody();
            PlantioEntity entity = plantioMapper.DtoToEntity(plantio);
            entity.AlterarIdentificador(areaNome);
            plantio = plantioMapper.EntityToDto(entity);
            SalarAlteracao(plantio);
            for(Linha linha : plantio.getLinhas())
            {
                caseLinhaPut.AlterarIdentificador(linha.getId(),plantio.getIdentificador());
            }
            return new ResponseEntity<>(plantio,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Plantio> NovaAdubacao(Long id, String relatorio)
    {
        try
        {
            if(id == null){throw new NullargumentsException();}
            if(relatorio == null){throw new NullargumentsException();}
            Plantio plantio = BuscarPlantioPorId(id).getBody();
            PlantioEntity entity = plantioMapper.DtoToEntity(plantio);
            entity.SetNovaAdubacao(relatorio);
            plantioRepository.save(entity);
            plantio = plantioMapper.EntityToDto(entity);
            return new ResponseEntity<>(plantio,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Plantio> SalarAlteracao(Plantio plantio)
    {
        try
        {
            if(plantio == null){throw new NullargumentsException();}
            PlantioEntity entity = plantioMapper.DtoToEntity(plantio);
            plantioRepository.save(entity);
            return new ResponseEntity<>(plantio, HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
