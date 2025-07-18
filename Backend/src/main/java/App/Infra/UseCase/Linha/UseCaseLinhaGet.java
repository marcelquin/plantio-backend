package App.Infra.UseCase.Linha;

import App.Domain.Response.Linha;
import App.Infra.Gateway.LinhaGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class UseCaseLinhaGet {

    private final LinhaGateway linhaGateway;

    public UseCaseLinhaGet(LinhaGateway linhaGateway) {
        this.linhaGateway = linhaGateway;
    }

    public ResponseEntity<List<Linha>> ListarLinhas()
    {return linhaGateway.ListarLinhas();}

    public ResponseEntity<Linha> BuscarLinhaPorId(@RequestParam Long id)
    {return linhaGateway.BuscarLinhaPorId(id);}

    public ResponseEntity<Linha> BuscarLinhaPorIentificador(@RequestParam String identidicador)
    {return linhaGateway.BuscarLinhaPorIentificador(identidicador);}

}
