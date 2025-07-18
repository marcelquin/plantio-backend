package App.Infra.Gateway;

import App.Domain.Response.Crecimento;
import App.Domain.Response.Floracao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface CrecimentoCicloGateway {

    public ResponseEntity<Crecimento> BuscarCorpoPorId(@RequestParam Long id);

    public ResponseEntity<Crecimento> NovoCiclo();

    public ResponseEntity<Crecimento> AtualizarEntidadeInicio(@RequestParam Long id);

    public ResponseEntity<Crecimento> AtualizarEntidadeFim(@RequestParam Long id);

    public ResponseEntity<Crecimento> SalvarAlteracao(@RequestBody Crecimento crecimento);

    public ResponseEntity<Void> DeletarPorId(@RequestParam Long id);

}
