package App.Infra.UseCase.Ciclo;

import App.Infra.Gateway.CicloGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseCicloDelete {

    private final CicloGateway cicloGateway;

    public UseCaseCicloDelete(CicloGateway cicloGateway) {
        this.cicloGateway = cicloGateway;
    }

    public ResponseEntity<Void> DeletarPorId(@RequestParam Long cicloId)
    {return cicloGateway.DeletarPorId(cicloId);}

}
