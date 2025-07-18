package App.Infra.UseCase.Ciclo;

import App.Domain.Response.Ciclo;
import App.Infra.Gateway.CicloGateway;
import App.Infra.Persistence.Enum.CICLO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseCicloPut {

    private final CicloGateway cicloGateway;

    public UseCaseCicloPut(CicloGateway cicloGateway) {
        this.cicloGateway = cicloGateway;
    }

    public ResponseEntity<Ciclo> AlterarCiclo(@RequestParam Long plantaId,
                                              @RequestParam CICLO ciclo)
    {return cicloGateway.AlterarCiclo(plantaId, ciclo);}

    public ResponseEntity<Ciclo> SalvarAlteracao(@RequestBody Ciclo ciclo)
    {return cicloGateway.SalvarAlteracao(ciclo);}

}
