package App.Infra.Gateway;

import App.Domain.Response.Ciclo;
import App.Domain.Response.Fim;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface FimCicloGateway {



    public ResponseEntity<Fim> BuscarCorpoPorId(@RequestParam Long id);

    public ResponseEntity<Fim> NovoCiclo();

    public ResponseEntity<Fim>AtualizarEntidade(@RequestBody Ciclo ciclo,
                                                @RequestParam String identificadorLocalizacao);

    public ResponseEntity<Fim> SalvarAlteracoes(@RequestBody Fim fim);

    public ResponseEntity<Void>DeletarPorId(@RequestParam Long id);


}
