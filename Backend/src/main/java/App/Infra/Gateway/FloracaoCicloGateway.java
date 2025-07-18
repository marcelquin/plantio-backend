package App.Infra.Gateway;

import App.Domain.Response.Floracao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface FloracaoCicloGateway {

    public ResponseEntity<Floracao> BuscarCorpoPorId(@RequestParam Long id);

    public ResponseEntity<Floracao> NovoCiclo();

    public ResponseEntity<Floracao> AtualizarEntidadeInicio(@RequestParam Long id);

    public ResponseEntity<Floracao> AtualizarEntidadeFim(@RequestParam Long id);

    public ResponseEntity<Floracao> SalvarAlteracao(@RequestBody Floracao floracao);

    public ResponseEntity<Void> DeletarPorId(@RequestParam Long id);

}
