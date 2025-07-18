package App.Infra.UseCase.MaturacaoCiclo;

import App.Domain.Response.Maturacao;
import App.Infra.Gateway.MaturacaoCicloGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseMaturacaoCicloGet {

    private final MaturacaoCicloGateway maturacaoCicloGateway;

    public UseCaseMaturacaoCicloGet(MaturacaoCicloGateway maturacaoCicloGateway) {
        this.maturacaoCicloGateway = maturacaoCicloGateway;
    }

    public ResponseEntity<Maturacao> BuscarCorpoPorId(@RequestParam Long id)
    {return maturacaoCicloGateway.BuscarCorpoPorId(id);}
}
