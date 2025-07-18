package App.Infra.UseCase.Plantio;

import App.Domain.Response.Plantio;
import App.Infra.Gateway.PlantioGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCasePlantioPut {

    private final PlantioGateway plantioGateway;

    public UseCasePlantioPut(PlantioGateway plantioGateway) {
        this.plantioGateway = plantioGateway;
    }

    public ResponseEntity<Plantio> AlterarIdentificador(@RequestParam Long id,
                                                        @RequestParam String areaNome)
    {return plantioGateway.AlterarIdentificador(id, areaNome);}

    public ResponseEntity<Plantio> NovaAdubacao(@RequestParam Long id,
                                                @RequestParam String relatorio)
    {return plantioGateway.NovaAdubacao(id, relatorio);}

    public ResponseEntity<Plantio> SalarAlteracao(@RequestBody Plantio plantio)
    {return plantioGateway.SalarAlteracao(plantio);}

}
