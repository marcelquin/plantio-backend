package App.Infra.UseCase.Plantio;

import App.Domain.Response.Plantio;
import App.Infra.Gateway.PlantioGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCasePlantioDelete {

    private final PlantioGateway plantioGateway;

    public UseCasePlantioDelete(PlantioGateway plantioGateway) {
        this.plantioGateway = plantioGateway;
    }

    public ResponseEntity<Void> DeletarPlantioPorId(@RequestParam Long plantioId)
    {return plantioGateway.DeletarPlantioPorId(plantioId);}

}
