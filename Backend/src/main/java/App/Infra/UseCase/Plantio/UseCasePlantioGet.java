package App.Infra.UseCase.Plantio;

import App.Domain.Response.Plantio;
import App.Infra.Gateway.PlantioGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class UseCasePlantioGet {

    private final PlantioGateway plantioGateway;

    public UseCasePlantioGet(PlantioGateway plantioGateway) {
        this.plantioGateway = plantioGateway;
    }

    public ResponseEntity<List<Plantio>> ListarPlantio()
    {return plantioGateway.ListarPlantio();}

    public ResponseEntity<Plantio> BuscarPlantioPorId(@RequestParam Long id)
    {return plantioGateway.BuscarPlantioPorId(id);}

    public ResponseEntity<Plantio> BuscarPlantioPorIdentificador(@RequestParam String identificador)
    {return plantioGateway.BuscarPlantioPorIdentificador(identificador);}

}
