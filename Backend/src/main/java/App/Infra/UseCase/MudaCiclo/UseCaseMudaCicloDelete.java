package App.Infra.UseCase.MudaCiclo;

import App.Infra.Gateway.MudaCicloGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseMudaCicloDelete {

    public final MudaCicloGateway mudaCicloGateway;

    public UseCaseMudaCicloDelete(MudaCicloGateway mudaCicloGateway) {
        this.mudaCicloGateway = mudaCicloGateway;
    }

    public ResponseEntity<Void> DeletarPorId(@RequestParam Long id)
    {return mudaCicloGateway.DeletarPorId(id);}
}
