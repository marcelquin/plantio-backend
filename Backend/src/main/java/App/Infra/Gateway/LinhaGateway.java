package App.Infra.Gateway;

import App.Domain.Response.Linha;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface LinhaGateway {

    public ResponseEntity<List<Linha>> ListarLinhas();

    public ResponseEntity<Linha> BuscarLinhaPorId(@RequestParam Long id);

    public ResponseEntity<Linha> NovaLinha(@RequestParam Long plantioId);

    public ResponseEntity<Void> SalvarAlteracao(@RequestBody Linha linha);

    public ResponseEntity<Linha> AlterarIdentificador(@RequestParam Long linhaId,
                                                      @RequestParam String identificadorPlantio);

    public ResponseEntity<Linha> DeletarLinhaPorId(@RequestParam Long linhaId);

    public ResponseEntity<Linha> BuscarLinhaPorIentificador(@RequestParam String identidicador);


}
