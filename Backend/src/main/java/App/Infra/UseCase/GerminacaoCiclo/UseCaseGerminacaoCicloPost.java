package App.Infra.UseCase.GerminacaoCiclo;

import App.Domain.Response.Germinacao;
import App.Infra.Gateway.GerminacaoCicloGateway;
import org.springframework.http.ResponseEntity;

public class UseCaseGerminacaoCicloPost {

    private final GerminacaoCicloGateway germinacaoCicloGateway;

    public UseCaseGerminacaoCicloPost(GerminacaoCicloGateway germinacaoCicloGateway) {
        this.germinacaoCicloGateway = germinacaoCicloGateway;
    }

    public ResponseEntity<Germinacao> NovoCiclo()
    {return germinacaoCicloGateway.NovoCiclo();}

}
