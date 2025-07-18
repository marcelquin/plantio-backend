package App.Infra.UseCase.FloracaoCiclo;

import App.Domain.Response.Floracao;
import App.Infra.Gateway.FloracaoCicloGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseFloracaoCicloGet {

    private final FloracaoCicloGateway floracaoCicloGateway;

    public UseCaseFloracaoCicloGet(FloracaoCicloGateway floracaoCicloGateway) {
        this.floracaoCicloGateway = floracaoCicloGateway;
    }

    public ResponseEntity<Floracao> BuscarCorpoPorId(@RequestParam Long id)
    {return floracaoCicloGateway.BuscarCorpoPorId(id);}
}
