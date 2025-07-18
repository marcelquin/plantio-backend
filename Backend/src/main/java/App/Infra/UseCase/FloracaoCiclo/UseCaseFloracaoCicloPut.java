package App.Infra.UseCase.FloracaoCiclo;

import App.Domain.Response.Floracao;
import App.Infra.Gateway.FloracaoCicloGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseFloracaoCicloPut {

    private final FloracaoCicloGateway floracaoCicloGateway;

    public UseCaseFloracaoCicloPut(FloracaoCicloGateway floracaoCicloGateway) {
        this.floracaoCicloGateway = floracaoCicloGateway;
    }

    public ResponseEntity<Floracao> AtualizarEntidadeInicio(@RequestParam Long id)
    {return floracaoCicloGateway.AtualizarEntidadeInicio(id);}

    public ResponseEntity<Floracao> AtualizarEntidadeFim(@RequestParam Long id)
    {return floracaoCicloGateway.AtualizarEntidadeFim(id);}

    public ResponseEntity<Floracao> SalvarAlteracao(@RequestBody Floracao floracao)
    {return floracaoCicloGateway.SalvarAlteracao(floracao);}
}
