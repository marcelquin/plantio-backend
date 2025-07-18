package App.Infra.UseCase.Crecimento;

import App.Domain.Response.Crecimento;
import App.Infra.Gateway.CrecimentoCicloGateway;
import org.springframework.http.ResponseEntity;

public class UseCaseCrecimentoCicloPost {

    private final CrecimentoCicloGateway crecimentoCicloGateway;

    public UseCaseCrecimentoCicloPost(CrecimentoCicloGateway crecimentoCicloGateway) {
        this.crecimentoCicloGateway = crecimentoCicloGateway;
    }

    public ResponseEntity<Crecimento> NovoCiclo()
    {return crecimentoCicloGateway.NovoCiclo();}
}
