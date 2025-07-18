package App.Infra.UseCase.FrutificacaoCiclo;

import App.Domain.Response.Frutificacao;
import App.Infra.Gateway.FrutificacaoCicloGateway;
import org.springframework.http.ResponseEntity;

public class UseCaseFrutificacaoCicloPost {

    private final FrutificacaoCicloGateway frutificacaoCicloGateway;

    public UseCaseFrutificacaoCicloPost(FrutificacaoCicloGateway frutificacaoCicloGateway) {
        this.frutificacaoCicloGateway = frutificacaoCicloGateway;
    }

    public ResponseEntity<Frutificacao> NovoCiclo()
    {return frutificacaoCicloGateway.NovoCiclo();}
}
