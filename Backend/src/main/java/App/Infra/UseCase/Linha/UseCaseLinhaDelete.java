package App.Infra.UseCase.Linha;

import App.Domain.Response.Linha;
import App.Infra.Gateway.LinhaGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class UseCaseLinhaDelete {

    private final LinhaGateway linhaGateway;

    public UseCaseLinhaDelete(LinhaGateway linhaGateway) {
        this.linhaGateway = linhaGateway;
    }

    public ResponseEntity<Linha> DeletarLinhaPorId(@RequestParam Long linhaId)
    {return linhaGateway.DeletarLinhaPorId(linhaId);}

}
