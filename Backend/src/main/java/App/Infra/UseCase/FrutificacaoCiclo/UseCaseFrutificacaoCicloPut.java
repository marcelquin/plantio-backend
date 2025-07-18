package App.Infra.UseCase.FrutificacaoCiclo;

import App.Domain.Response.Frutificacao;
import App.Domain.Response.Maturacao;
import App.Infra.Gateway.FrutificacaoCicloGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseFrutificacaoCicloPut {

    private final FrutificacaoCicloGateway frutificacaoCicloGateway;

    public UseCaseFrutificacaoCicloPut(FrutificacaoCicloGateway frutificacaoCicloGateway) {
        this.frutificacaoCicloGateway = frutificacaoCicloGateway;
    }

    public ResponseEntity<Frutificacao> AtualizarEntidadeInicio(@RequestParam Long id)
    {return frutificacaoCicloGateway.AtualizarEntidadeInicio(id);}

    public ResponseEntity<Frutificacao> AtualizarEntidadeFim(@RequestParam Long id)
    {return frutificacaoCicloGateway.AtualizarEntidadeFim(id);}

    public ResponseEntity<Frutificacao> SalvarAlteracao(@RequestBody Frutificacao frutificacao)
    {return frutificacaoCicloGateway.SalvarAlteracao(frutificacao);}

}
