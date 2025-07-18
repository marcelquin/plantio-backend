package App.Infra.UseCase.FloracaoCiclo;

import App.Domain.Response.Floracao;
import App.Infra.Gateway.FloracaoCicloGateway;
import org.springframework.http.ResponseEntity;

public class UseCaseFloracaoCicloPost {

    private final FloracaoCicloGateway floracaoCicloGateway;

    public UseCaseFloracaoCicloPost(FloracaoCicloGateway floracaoCicloGateway) {
        this.floracaoCicloGateway = floracaoCicloGateway;
    }

    public ResponseEntity<Floracao> NovoCiclo()
    {return floracaoCicloGateway.NovoCiclo();}
}
