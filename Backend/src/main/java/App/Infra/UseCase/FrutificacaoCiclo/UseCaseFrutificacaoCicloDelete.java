package App.Infra.UseCase.FrutificacaoCiclo;

import App.Infra.Gateway.FrutificacaoCicloGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseFrutificacaoCicloDelete {

    private final FrutificacaoCicloGateway frutificacaoCicloGateway;

    public UseCaseFrutificacaoCicloDelete(FrutificacaoCicloGateway frutificacaoCicloGateway) {
        this.frutificacaoCicloGateway = frutificacaoCicloGateway;
    }

    public ResponseEntity<Void> DeletarPorId(@RequestParam Long id)
    {return frutificacaoCicloGateway.DeletarPorId(id);}

}
