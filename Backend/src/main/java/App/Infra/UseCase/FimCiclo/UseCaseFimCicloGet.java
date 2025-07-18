package App.Infra.UseCase.FimCiclo;

import App.Domain.Response.Fim;
import App.Infra.Gateway.FimCicloGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseFimCicloGet {

    private final FimCicloGateway fimCicloGateway;

    public UseCaseFimCicloGet(FimCicloGateway fimCicloGateway) {
        this.fimCicloGateway = fimCicloGateway;
    }

    public ResponseEntity<Fim> BuscarCorpoPorId(@RequestParam Long id)
    {return fimCicloGateway.BuscarCorpoPorId(id);}

}
