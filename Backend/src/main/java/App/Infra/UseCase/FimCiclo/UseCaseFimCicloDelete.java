package App.Infra.UseCase.FimCiclo;

import App.Infra.Gateway.FimCicloGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseFimCicloDelete {

    private final FimCicloGateway fimCicloGateway;

    public UseCaseFimCicloDelete(FimCicloGateway fimCicloGateway) {
        this.fimCicloGateway = fimCicloGateway;
    }

    public ResponseEntity<Void> DeletarPorId(@RequestParam Long id)
    {return fimCicloGateway.DeletarPorId(id);}


}
