package App.Domain.Bussness;

import App.Domain.Response.*;
import App.Infra.Exceptions.EntityNotFoundException;
import App.Infra.Exceptions.NullargumentsException;
import App.Infra.Gateway.AreaGateway;
import App.Infra.Mapper.AreaMapper;
import App.Infra.Mapper.LinhaMapper;
import App.Infra.Mapper.LocalizacaoMapper;
import App.Infra.Mapper.PlantioMapper;
import App.Infra.Persistence.Entity.AreaEntity;
import App.Infra.Persistence.Entity.LinhaEntity;
import App.Infra.Persistence.Entity.LocalizacaoEntity;
import App.Infra.Persistence.Entity.PlantioEntity;
import App.Infra.Persistence.Repository.AreaRepository;
import App.Infra.UseCase.Plantio.UseCasePlantioDelete;
import App.Infra.UseCase.Plantio.UseCasePlantioPut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AreaService implements AreaGateway {

    private final AreaRepository areaRepository;
    private final AreaMapper areaMapper;
    private final UseCasePlantioPut casePlantioPut;
    private final UseCasePlantioDelete useCasePlantioDelete;


    public AreaService(AreaRepository areaRepository,
                       AreaMapper areaMapper,
                       @Lazy UseCasePlantioPut casePlantioPut,
                       @Lazy UseCasePlantioDelete useCasePlantioDelete) {
        this.areaRepository = areaRepository;
        this.areaMapper = areaMapper;
        this.casePlantioPut = casePlantioPut;
        this.useCasePlantioDelete = useCasePlantioDelete;
    }


    @Override
    public ResponseEntity<List<Area>> ListarAreas()
    {
        try
        {
            List<AreaEntity> list = areaRepository.findAll();
            List<Area> response = new ArrayList<>();
            for(AreaEntity entity : list)
            {
                Area area = areaMapper.EntityToDto(entity);
                response.add(area);
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
    public ResponseEntity<Area> BuscarAreaPorId(Long id)
    {
        try
        {
            if(id == null){throw new NullargumentsException();}
            AreaEntity entity = areaRepository.findById(id).orElseThrow(
                    EntityNotFoundException::new
            );
            Area response = areaMapper.EntityToDto(entity);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Area> BuscarAreaPorNome(String nome)
    {
        try
        {
            if(nome == null){throw new NullargumentsException();}
            AreaEntity entity = areaRepository.findBynome(nome).orElseThrow(
                    EntityNotFoundException::new
            );
            Area response = areaMapper.EntityToDto(entity);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Area> NovaArea(String nome,
                                         String dimensao,
                                         String gps)
    {
        try
        {
            if(nome == null){throw new NullargumentsException();}
            if(dimensao == null){throw new NullargumentsException();}
            if(gps == null){throw new NullargumentsException();}
            AreaEntity entity = new AreaEntity();
            entity.SetInfoInicial(nome,dimensao,gps);
            areaRepository.save(entity);
            Area response = areaMapper.EntityToDto(entity);
            return new ResponseEntity<>(response,HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Area> EditarInformacoesArea(Long id,
                                                      String nome,
                                                      String dimensao,
                                                      String gps)
    {
        try
        {
            if(id == null){throw new NullargumentsException();}
            if(nome == null){throw new NullargumentsException();}
            if(dimensao == null){throw new NullargumentsException();}
            if(gps == null){throw new NullargumentsException();}
            Area area = BuscarAreaPorId(id).getBody();
            AreaEntity entity = areaMapper.DtoToEntity(area);
            entity.EditInfol(nome,dimensao,gps);
            area = areaMapper.EntityToDto(entity);
            SalvarAlteracoes(area);
            for(Plantio plantio : area.getPlantios())
            {
                casePlantioPut.AlterarIdentificador(plantio.getId(),area.getNome());
            }
            return new ResponseEntity<>(area, HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Area> SalvarAlteracoes(Area area)
    {
        try
        {
            if(area == null){throw new NullargumentsException();}
            AreaEntity entity = areaMapper.DtoToEntity(area);
            areaRepository.save(entity);
            return new ResponseEntity<>(area,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Area> DeletarAreaPorId(Long areaId)
    {
        try
        {
            if(areaId == null){throw new NullargumentsException();}
            Area area = BuscarAreaPorId(areaId).getBody();
            for (Plantio plantio : area.getPlantios())
            {
                useCasePlantioDelete.DeletarPlantioPorId(plantio.getId());
            }
            areaRepository.deleteById(area.getId());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }



}
