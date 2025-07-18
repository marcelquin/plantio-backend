package App.Infra.UseCase.MudaCiclo;

import App.Domain.Response.Muda;
import App.Infra.Gateway.MudaCicloGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseMudaCicloGet {

    public final MudaCicloGateway mudaCicloGateway;

    public UseCaseMudaCicloGet(MudaCicloGateway mudaCicloGateway) {
        this.mudaCicloGateway = mudaCicloGateway;
    }

    public ResponseEntity<Muda> BuscarCorpoPorId(@RequestParam Long id)
    {return mudaCicloGateway.BuscarCorpoPorId(id);}
}
