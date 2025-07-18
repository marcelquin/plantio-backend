package App.Infra.UseCase.Linha;

import App.Domain.Response.Linha;
import App.Infra.Gateway.LinhaGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class UseCaseLinhaPost {

    private final LinhaGateway linhaGateway;

    public UseCaseLinhaPost(LinhaGateway linhaGateway) {
        this.linhaGateway = linhaGateway;
    }

    public ResponseEntity<Linha> NovaLinha(@RequestParam Long plantioId)
    {return linhaGateway.NovaLinha(plantioId);}

}
