package App.Infra.UseCase.Ciclo;

import App.Domain.Response.Ciclo;
import App.Infra.Gateway.CicloGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseCicloGet {

    private final CicloGateway cicloGateway;

    public UseCaseCicloGet(CicloGateway cicloGateway) {
        this.cicloGateway = cicloGateway;
    }

    public ResponseEntity<Ciclo> BuscarCicloPorId(@RequestParam Long id)
    {return cicloGateway.BuscarCicloPorId(id);}


}
