package App.Infra.Gateway;

import App.Domain.Response.Maturacao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface MaturacaoCicloGateway {

    public ResponseEntity<Maturacao> BuscarCorpoPorId(@RequestParam Long id);

    public ResponseEntity<Maturacao> NovoCiclo();

    public ResponseEntity<Maturacao> AtualizarEntidadeInicio(@RequestParam Long id);

    public ResponseEntity<Maturacao> AtualizarEntidadeFim(@RequestParam Long id);

    public ResponseEntity<Maturacao> SalvarAlteracao(@RequestBody Maturacao maturacao);

    public ResponseEntity<Void> DeletarPorId(@RequestParam Long id);

}
