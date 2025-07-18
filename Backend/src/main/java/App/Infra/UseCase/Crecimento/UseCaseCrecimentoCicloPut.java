package App.Infra.UseCase.Crecimento;

import App.Domain.Response.Crecimento;
import App.Infra.Gateway.CrecimentoCicloGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseCrecimentoCicloPut {

    private final CrecimentoCicloGateway crecimentoCicloGateway;

    public UseCaseCrecimentoCicloPut(CrecimentoCicloGateway crecimentoCicloGateway) {
        this.crecimentoCicloGateway = crecimentoCicloGateway;
    }

    public ResponseEntity<Crecimento> AtualizarEntidadeInicio(@RequestParam Long id)
    {return crecimentoCicloGateway.AtualizarEntidadeInicio(id);}

    public ResponseEntity<Crecimento> AtualizarEntidadeFim(@RequestParam Long id)
    {return crecimentoCicloGateway.AtualizarEntidadeFim(id);}

    public ResponseEntity<Crecimento> SalvarAlteracao(@RequestBody Crecimento crecimento)
    {return crecimentoCicloGateway.SalvarAlteracao(crecimento);}


}
