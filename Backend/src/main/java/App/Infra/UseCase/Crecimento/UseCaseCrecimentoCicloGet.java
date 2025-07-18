package App.Infra.UseCase.Crecimento;

import App.Domain.Response.Crecimento;
import App.Infra.Gateway.CrecimentoCicloGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseCrecimentoCicloGet {

    private final CrecimentoCicloGateway crecimentoCicloGateway;

    public UseCaseCrecimentoCicloGet(CrecimentoCicloGateway crecimentoCicloGateway) {
        this.crecimentoCicloGateway = crecimentoCicloGateway;
    }

    public ResponseEntity<Crecimento> BuscarCorpoPorId(@RequestParam Long id)
    {return crecimentoCicloGateway.BuscarCorpoPorId(id);}
}
