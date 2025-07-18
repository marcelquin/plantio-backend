package App.Infra.Gateway;

import App.Domain.Response.Plantio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PlantioGateway {

    public ResponseEntity<List<Plantio>> ListarPlantio();

    public ResponseEntity<Plantio> BuscarPlantioPorId(@RequestParam Long id);

    public ResponseEntity<Plantio> BuscarPlantioPorIdentificador(@RequestParam String identificador);


    public ResponseEntity<Plantio> NovoPlantio(@RequestParam Long areaId);

    public ResponseEntity<Plantio> AlterarIdentificador(@RequestParam Long id,
                                                        @RequestParam String areaNome);


    public ResponseEntity<Plantio> NovaAdubacao(@RequestParam Long id,
                                                @RequestParam String relatorio);

    public ResponseEntity<Void> DeletarPlantioPorId(@RequestParam Long plantioId);

    public ResponseEntity<Plantio> SalarAlteracao(@RequestBody Plantio plantio);

}
