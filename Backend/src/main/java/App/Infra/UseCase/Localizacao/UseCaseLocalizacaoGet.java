package App.Infra.UseCase.Localizacao;

import App.Domain.Response.Localizacao;
import App.Infra.Gateway.LocalizacaoGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class UseCaseLocalizacaoGet {

    private final LocalizacaoGateway localizacaoGateway;

    public UseCaseLocalizacaoGet(LocalizacaoGateway localizacaoGateway) {
        this.localizacaoGateway = localizacaoGateway;
    }

    public ResponseEntity<List<Localizacao>> ListarLocalizacoes()
    {return localizacaoGateway.ListarLocalizacoes();}

    public ResponseEntity<List<Localizacao>> ListarLocalizacoesDisponiveis()
    {return localizacaoGateway.ListarLocalizacoesDisponiveis();}


    public ResponseEntity<List<Localizacao>> ListarLocalizacoesNaoDisponiveis()
    {return localizacaoGateway.ListarLocalizacoesNaoDisponiveis();}

    public ResponseEntity<Localizacao> BuscarLocalizacaoPorId(@RequestParam Long id)
    {return localizacaoGateway.BuscarLocalizacaoPorId(id);}

    public ResponseEntity<Localizacao> BuscarLocalizacaoPorReferencia(@RequestParam String referencia)
    {return localizacaoGateway.BuscarLocalizacaoPorReferencia(referencia);}
}
