package App.Infra.Gateway;

import App.Domain.Response.Ciclo;
import App.Infra.Persistence.Enum.CICLO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface CicloGateway {

    public ResponseEntity<Ciclo> BuscarCicloPorId(@RequestParam Long id);

    public ResponseEntity<Ciclo> NovoCiclo();

    public ResponseEntity<Ciclo> AlterarCiclo(@RequestParam Long plantaId,
                                              @RequestParam CICLO ciclo);

    public ResponseEntity<Ciclo> SalvarAlteracao(@RequestBody Ciclo ciclo);

    public ResponseEntity<Void> DeletarPorId(@RequestParam Long cicloId);

}
