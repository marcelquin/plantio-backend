package App.Infra.UseCase.Ciclo;

import App.Domain.Response.Ciclo;
import App.Infra.Gateway.CicloGateway;
import org.springframework.http.ResponseEntity;

public class UseCaseCicloPost {

    private final CicloGateway cicloGateway;

    public UseCaseCicloPost(CicloGateway cicloGateway) {
        this.cicloGateway = cicloGateway;
    }

    public ResponseEntity<Ciclo> NovoCiclo()
    {return cicloGateway.NovoCiclo();}

}
