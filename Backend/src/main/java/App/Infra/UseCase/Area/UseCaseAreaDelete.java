package App.Infra.UseCase.Area;

import App.Domain.Response.Area;
import App.Infra.Gateway.AreaGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseAreaDelete {

    private final AreaGateway areaGateway;

    public UseCaseAreaDelete(AreaGateway areaGateway) {
        this.areaGateway = areaGateway;
    }

    public ResponseEntity<Area> DeletarAreaPorId(@RequestParam Long areaId)
    {return areaGateway.DeletarAreaPorId(areaId);}


}
