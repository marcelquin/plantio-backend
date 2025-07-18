package App.Infra.UseCase.Localizacao;

import App.Domain.Response.Localizacao;
import App.Domain.Response.Planta;
import App.Infra.Gateway.LocalizacaoGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class UseCaseLocalizacaoPut {

    private final LocalizacaoGateway localizacaoGateway;

    public UseCaseLocalizacaoPut(LocalizacaoGateway localizacaoGateway) {
        this.localizacaoGateway = localizacaoGateway;
    }
    public ResponseEntity<Localizacao> AlterarReferencia(@RequestParam Long id,
                                                         @RequestParam String identificadorLinha)
    {return localizacaoGateway.AlterarReferencia(id, identificadorLinha);}

    public ResponseEntity<Localizacao> IndisponibilizarLocalizacao(@RequestParam Long localizacaoId,@RequestBody Planta planta)
    {return localizacaoGateway.IndisponibilizarLocalizacao(localizacaoId,planta);}

    public ResponseEntity<Localizacao> DisponibilizarLocalizacao(@RequestParam Long localizacaoId)
    {return localizacaoGateway.DisponibilizarLocalizacao(localizacaoId);}


    public ResponseEntity<Void> SalvarAlteracao(@RequestBody Localizacao localizacao)
    {return localizacaoGateway.SalvarAlteracao(localizacao);}
}
