package App.Infra.UseCase.MaturacaoCiclo;

import App.Domain.Response.Maturacao;
import App.Infra.Gateway.MaturacaoCicloGateway;
import org.springframework.http.ResponseEntity;

public class UseCaseMaturacaoCicloPost {

    private final MaturacaoCicloGateway maturacaoCicloGateway;

    public UseCaseMaturacaoCicloPost(MaturacaoCicloGateway maturacaoCicloGateway) {
        this.maturacaoCicloGateway = maturacaoCicloGateway;
    }

    public ResponseEntity<Maturacao> NovoCiclo()
    {return maturacaoCicloGateway.NovoCiclo();}
}
