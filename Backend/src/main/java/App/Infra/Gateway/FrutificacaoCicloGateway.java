package App.Infra.Gateway;

import App.Domain.Response.Frutificacao;
import App.Domain.Response.Maturacao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface FrutificacaoCicloGateway {

    public ResponseEntity<Frutificacao> BuscarCorpoPorId(@RequestParam Long id);

    public ResponseEntity<Frutificacao> NovoCiclo();

    public ResponseEntity<Frutificacao> AtualizarEntidadeInicio(@RequestParam Long id);

    public ResponseEntity<Frutificacao> AtualizarEntidadeFim(@RequestParam Long id);

    public ResponseEntity<Frutificacao> SalvarAlteracao(@RequestBody Frutificacao frutificacao);

    public ResponseEntity<Void> DeletarPorId(@RequestParam Long id);

}
