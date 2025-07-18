package App.Infra.UseCase.GerminacaoCiclo;

import App.Infra.Gateway.GerminacaoCicloGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseGerminacaoCicloDelete {

    private final GerminacaoCicloGateway germinacaoCicloGateway;

    public UseCaseGerminacaoCicloDelete(GerminacaoCicloGateway germinacaoCicloGateway) {
        this.germinacaoCicloGateway = germinacaoCicloGateway;
    }

    public ResponseEntity<Void> DeletarPorId(@RequestParam Long id)
    {return germinacaoCicloGateway.DeletarPorId(id);}

}
