package App.Infra.UseCase.Area;

import App.Domain.Response.Area;
import App.Infra.Gateway.AreaGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseAreaPut {

    private final AreaGateway areaGateway;

    public UseCaseAreaPut(AreaGateway areaGateway) {
        this.areaGateway = areaGateway;
    }

    public ResponseEntity<Area> EditarInformacoesArea(@RequestParam Long id,
                                                      @RequestParam String nome,
                                                      @RequestParam String dimensao,
                                                      @RequestParam String gps)
    {return areaGateway.EditarInformacoesArea(id, nome, dimensao, gps);}

    public ResponseEntity<Area> SalvarAlteracoes(@RequestBody Area area)
    {return areaGateway.SalvarAlteracoes(area);}

}
