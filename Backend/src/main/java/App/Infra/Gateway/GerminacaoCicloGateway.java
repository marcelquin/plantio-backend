package App.Infra.Gateway;

import App.Domain.Response.Germinacao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface GerminacaoCicloGateway {

    public ResponseEntity<Germinacao> BuscarCorpoPorId(@RequestParam Long id);

    public ResponseEntity<Germinacao> NovoCiclo();

    public ResponseEntity<Germinacao> AtualizarEntidadeFim(@RequestParam Long id);

    public ResponseEntity<Germinacao> SalvarAlteracao(@RequestBody Germinacao germinacao);

    public ResponseEntity<Void> DeletarPorId(@RequestParam Long id);

}
