package App.Infra.UseCase.FimCiclo;

import App.Domain.Response.Ciclo;
import App.Domain.Response.Fim;
import App.Infra.Gateway.FimCicloGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseFimCicloPut {

    private final FimCicloGateway fimCicloGateway;

    public UseCaseFimCicloPut(FimCicloGateway fimCicloGateway) {
        this.fimCicloGateway = fimCicloGateway;
    }

    public ResponseEntity<Fim> AtualizarEntidade(@RequestBody Ciclo ciclo,
                                                 @RequestParam String identificadorLocalizacao)
    {return fimCicloGateway.AtualizarEntidade(ciclo, identificadorLocalizacao);}

    public ResponseEntity<Fim> SalvarAlteracoes(@RequestBody Fim fim)
    {return fimCicloGateway.SalvarAlteracoes(fim);}

}
