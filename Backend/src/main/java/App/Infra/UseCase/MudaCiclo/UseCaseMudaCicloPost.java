package App.Infra.UseCase.MudaCiclo;

import App.Domain.Response.Muda;
import App.Infra.Gateway.MudaCicloGateway;
import org.springframework.http.ResponseEntity;

public class UseCaseMudaCicloPost {

    public final MudaCicloGateway mudaCicloGateway;

    public UseCaseMudaCicloPost(MudaCicloGateway mudaCicloGateway) {
        this.mudaCicloGateway = mudaCicloGateway;
    }

    public ResponseEntity<Muda> NovoCiclo()
    {return mudaCicloGateway.NovoCiclo();}

}
