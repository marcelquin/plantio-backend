package App.Infra.UseCase.GerminacaoCiclo;

import App.Domain.Response.Germinacao;
import App.Infra.Gateway.GerminacaoCicloGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseGerminacaoCicloGet {

    private final GerminacaoCicloGateway germinacaoCicloGateway;

    public UseCaseGerminacaoCicloGet(GerminacaoCicloGateway germinacaoCicloGateway) {
        this.germinacaoCicloGateway = germinacaoCicloGateway;
    }

    public ResponseEntity<Germinacao> BuscarCorpoPorId(@RequestParam Long id)
    {return germinacaoCicloGateway.BuscarCorpoPorId(id);}



}
