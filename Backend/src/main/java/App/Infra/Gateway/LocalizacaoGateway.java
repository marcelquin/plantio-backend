package App.Infra.Gateway;

import App.Domain.Response.Localizacao;
import App.Domain.Response.Planta;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface LocalizacaoGateway {

    public ResponseEntity<List<Localizacao>> ListarLocalizacoes();

    public ResponseEntity<List<Localizacao>> ListarLocalizacoesDisponiveis();

    public ResponseEntity<List<Localizacao>> ListarLocalizacoesNaoDisponiveis();

    public ResponseEntity<Localizacao> BuscarLocalizacaoPorId(@RequestParam Long id);

    public ResponseEntity<Localizacao> BuscarLocalizacaoPorReferencia(@RequestParam String referencia);

    public ResponseEntity<Localizacao> NovaLocalizacao(@RequestParam Long linhaId);

    public ResponseEntity<Localizacao> AlterarReferencia(@RequestParam Long id,
                                                         @RequestParam String identificadorLinha);

    public ResponseEntity<Localizacao> IndisponibilizarLocalizacao(@RequestParam Long localizacaoId, @RequestBody Planta planta);

    public ResponseEntity<Localizacao> DisponibilizarLocalizacao(@RequestParam Long localizacaoId);

    public ResponseEntity<Void> SalvarAlteracao(@RequestBody Localizacao localizacao);

    public ResponseEntity<Localizacao> DeletarLocalizacaoPorId(@RequestParam Long localizacaoId);
}
