package App.Infra.UseCase.FrutificacaoCiclo;

import App.Domain.Response.Frutificacao;
import App.Infra.Gateway.FrutificacaoCicloGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseFrutificacaoCicloGet {

    private final FrutificacaoCicloGateway frutificacaoCicloGateway;

    public UseCaseFrutificacaoCicloGet(FrutificacaoCicloGateway frutificacaoCicloGateway) {
        this.frutificacaoCicloGateway = frutificacaoCicloGateway;
    }

    public ResponseEntity<Frutificacao> BuscarCorpoPorId(@RequestParam Long id)
    {return frutificacaoCicloGateway.BuscarCorpoPorId(id);}
}
