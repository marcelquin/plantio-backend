package App.Infra.UseCase.Planta;

import App.Domain.Response.Planta;
import App.Infra.Gateway.PlantaGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCasePlantaDelete {

    private final PlantaGateway plantaGateway;

    public UseCasePlantaDelete(PlantaGateway plantaGateway) {
        this.plantaGateway = plantaGateway;
    }

    public ResponseEntity<Void> DeletarPlantaPorId(@RequestParam Long id)
    {return plantaGateway.DeletarPlantaPorId(id);}


}
