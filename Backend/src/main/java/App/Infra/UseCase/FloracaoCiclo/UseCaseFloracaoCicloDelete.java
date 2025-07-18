package App.Infra.UseCase.FloracaoCiclo;

import App.Infra.Gateway.FloracaoCicloGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseFloracaoCicloDelete {

    private final FloracaoCicloGateway floracaoCicloGateway;

    public UseCaseFloracaoCicloDelete(FloracaoCicloGateway floracaoCicloGateway) {
        this.floracaoCicloGateway = floracaoCicloGateway;
    }

    public ResponseEntity<Void> DeletarPorId(@RequestParam Long id)
    {return floracaoCicloGateway.DeletarPorId(id);}
}
