package App.Infra.UseCase.Crecimento;

import App.Infra.Gateway.CrecimentoCicloGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseCrecimentoCicloDelete {

    private final CrecimentoCicloGateway crecimentoCicloGateway;

    public UseCaseCrecimentoCicloDelete(CrecimentoCicloGateway crecimentoCicloGateway) {
        this.crecimentoCicloGateway = crecimentoCicloGateway;
    }

    public ResponseEntity<Void> DeletarPorId(@RequestParam Long id)
    {return crecimentoCicloGateway.DeletarPorId(id);}

}
