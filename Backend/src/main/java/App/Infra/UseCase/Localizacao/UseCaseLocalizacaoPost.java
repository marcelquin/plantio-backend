package App.Infra.UseCase.Localizacao;

import App.Domain.Response.Localizacao;
import App.Infra.Gateway.LocalizacaoGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class UseCaseLocalizacaoPost {

    private final LocalizacaoGateway localizacaoGateway;

    public UseCaseLocalizacaoPost(LocalizacaoGateway localizacaoGateway) {
        this.localizacaoGateway = localizacaoGateway;
    }

    public ResponseEntity<Localizacao> NovaLocalizacao(@RequestParam Long linhaId)
    {return localizacaoGateway.NovaLocalizacao(linhaId);}
}
