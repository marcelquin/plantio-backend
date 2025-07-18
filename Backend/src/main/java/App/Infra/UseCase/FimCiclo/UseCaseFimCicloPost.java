package App.Infra.UseCase.FimCiclo;

import App.Domain.Response.Fim;
import App.Infra.Gateway.FimCicloGateway;
import org.springframework.http.ResponseEntity;

public class UseCaseFimCicloPost {

    private final FimCicloGateway fimCicloGateway;

    public UseCaseFimCicloPost(FimCicloGateway fimCicloGateway) {
        this.fimCicloGateway = fimCicloGateway;
    }

    public ResponseEntity<Fim> NovoCiclo()
    {return fimCicloGateway.NovoCiclo();}
}
