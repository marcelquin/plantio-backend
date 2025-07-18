package App.Infra.UseCase.MaturacaoCiclo;

import App.Domain.Response.Maturacao;
import App.Infra.Gateway.MaturacaoCicloGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseMaturacaoCicloPut {

    private final MaturacaoCicloGateway maturacaoCicloGateway;

    public UseCaseMaturacaoCicloPut(MaturacaoCicloGateway maturacaoCicloGateway) {
        this.maturacaoCicloGateway = maturacaoCicloGateway;
    }

    public ResponseEntity<Maturacao> AtualizarEntidadeInicio(@RequestParam Long id)
    {return maturacaoCicloGateway.AtualizarEntidadeInicio(id);}

    public ResponseEntity<Maturacao> AtualizarEntidadeFim(@RequestParam Long id)
    {return maturacaoCicloGateway.AtualizarEntidadeFim(id);}

    public ResponseEntity<Maturacao> SalvarAlteracao(@RequestBody Maturacao maturacao)
    {return maturacaoCicloGateway.SalvarAlteracao(maturacao);}

}
