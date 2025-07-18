package App.Infra.UseCase.Plantio;

import App.Domain.Response.Plantio;
import App.Infra.Gateway.PlantioGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCasePlantioPost {

    private final PlantioGateway plantioGateway;

    public UseCasePlantioPost(PlantioGateway plantioGateway) {
        this.plantioGateway = plantioGateway;
    }

    public ResponseEntity<Plantio> NovoPlantio(@RequestParam Long areaId)
    {return plantioGateway.NovoPlantio(areaId);}

}
