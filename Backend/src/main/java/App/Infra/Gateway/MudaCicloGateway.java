package App.Infra.Gateway;

import App.Domain.Response.Crecimento;
import App.Domain.Response.Muda;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface MudaCicloGateway {

    public ResponseEntity<Muda> BuscarCorpoPorId(@RequestParam Long id);

    public ResponseEntity<Muda> NovoCiclo();

    public ResponseEntity<Muda> AtualizarEntidadeInicio(@RequestParam Long id);

    public ResponseEntity<Muda> AtualizarEntidadeFim(@RequestParam Long id);

    public ResponseEntity<Muda> SalvarAlteracao(@RequestBody Muda muda);

    public ResponseEntity<Void> DeletarPorId(@RequestParam Long id);

}
