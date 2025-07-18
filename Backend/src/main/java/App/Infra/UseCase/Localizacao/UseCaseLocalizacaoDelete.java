package App.Infra.UseCase.Localizacao;

import App.Domain.Response.Localizacao;
import App.Infra.Gateway.LocalizacaoGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class UseCaseLocalizacaoDelete {

    private final LocalizacaoGateway localizacaoGateway;

    public UseCaseLocalizacaoDelete(LocalizacaoGateway localizacaoGateway) {
        this.localizacaoGateway = localizacaoGateway;
    }

    public ResponseEntity<Localizacao> DeletarLocalizacaoPorId(@RequestParam Long localizacaoId)
    {return localizacaoGateway.DeletarLocalizacaoPorId(localizacaoId);}
}
