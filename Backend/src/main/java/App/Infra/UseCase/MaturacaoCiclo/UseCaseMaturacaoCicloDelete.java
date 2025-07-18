package App.Infra.UseCase.MaturacaoCiclo;

import App.Infra.Gateway.MaturacaoCicloGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseMaturacaoCicloDelete {

    private final MaturacaoCicloGateway maturacaoCicloGateway;

    public UseCaseMaturacaoCicloDelete(MaturacaoCicloGateway maturacaoCicloGateway) {
        this.maturacaoCicloGateway = maturacaoCicloGateway;
    }

    public ResponseEntity<Void> DeletarPorId(@RequestParam Long id)
    {return maturacaoCicloGateway.DeletarPorId(id);}
}
