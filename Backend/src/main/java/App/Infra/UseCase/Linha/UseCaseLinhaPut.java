package App.Infra.UseCase.Linha;

import App.Domain.Response.Linha;
import App.Infra.Gateway.LinhaGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class UseCaseLinhaPut {

    private final LinhaGateway linhaGateway;

    public UseCaseLinhaPut(LinhaGateway linhaGateway) {
        this.linhaGateway = linhaGateway;
    }

    public ResponseEntity<Linha> AlterarIdentificador(@RequestParam Long linhaId,
                                                      @RequestParam String identificadorPlantio)
    {return linhaGateway.AlterarIdentificador(linhaId, identificadorPlantio);}

    public ResponseEntity<Void> SalvarAlteracao(@RequestBody Linha linha)
    {return linhaGateway.SalvarAlteracao(linha);}

}
