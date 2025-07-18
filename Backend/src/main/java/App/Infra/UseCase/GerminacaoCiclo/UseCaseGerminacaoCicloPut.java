package App.Infra.UseCase.GerminacaoCiclo;

import App.Domain.Response.Germinacao;
import App.Infra.Gateway.GerminacaoCicloGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseGerminacaoCicloPut {

    private final GerminacaoCicloGateway germinacaoCicloGateway;

    public UseCaseGerminacaoCicloPut(GerminacaoCicloGateway germinacaoCicloGateway) {
        this.germinacaoCicloGateway = germinacaoCicloGateway;
    }

    public ResponseEntity<Germinacao> AtualizarEntidadeFim(@RequestParam Long id)
    {return germinacaoCicloGateway.AtualizarEntidadeFim(id);}

    public ResponseEntity<Germinacao> SalvarAlteracao(@RequestBody Germinacao germinacao)
    {return germinacaoCicloGateway.SalvarAlteracao(germinacao);}


}
