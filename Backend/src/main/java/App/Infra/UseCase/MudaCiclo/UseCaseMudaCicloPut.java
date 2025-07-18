package App.Infra.UseCase.MudaCiclo;

import App.Domain.Response.Muda;
import App.Infra.Gateway.MudaCicloGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseMudaCicloPut {

    public final MudaCicloGateway mudaCicloGateway;

    public UseCaseMudaCicloPut(MudaCicloGateway mudaCicloGateway) {
        this.mudaCicloGateway = mudaCicloGateway;
    }

    public ResponseEntity<Muda> AtualizarEntidadeInicio(@RequestParam Long id)
    {return mudaCicloGateway.AtualizarEntidadeInicio(id);}

    public ResponseEntity<Muda> AtualizarEntidadeFim(@RequestParam Long id)
    {return mudaCicloGateway.AtualizarEntidadeFim(id);}

    public ResponseEntity<Muda> SalvarAlteracao(@RequestBody Muda muda)
    {return mudaCicloGateway.SalvarAlteracao(muda);}

}
