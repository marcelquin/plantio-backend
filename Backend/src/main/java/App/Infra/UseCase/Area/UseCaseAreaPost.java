package App.Infra.UseCase.Area;

import App.Domain.Response.Area;
import App.Infra.Gateway.AreaGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseAreaPost {

    private final AreaGateway areaGateway;

    public UseCaseAreaPost(AreaGateway areaGateway) {
        this.areaGateway = areaGateway;
    }

    public ResponseEntity<Area> NovaArea(@RequestParam String nome,
                                         @RequestParam String dimensao,
                                         @RequestParam String gps)
    {return areaGateway.NovaArea(nome, dimensao, gps);}

}
