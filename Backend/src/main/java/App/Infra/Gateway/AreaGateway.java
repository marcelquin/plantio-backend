package App.Infra.Gateway;

import App.Domain.Response.Area;
import App.Domain.Response.AreaPesquisaResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface AreaGateway {

    public ResponseEntity<List<Area>> ListarAreas();

    public ResponseEntity<Area> BuscarAreaPorId(@RequestParam Long id);

    public ResponseEntity<Area> BuscarAreaPorNome(@RequestParam String nome);

    public ResponseEntity<Area> NovaArea(@RequestParam String nome,
                                         @RequestParam String dimensao,
                                         @RequestParam String gps);

    public ResponseEntity<Area> EditarInformacoesArea(@RequestParam Long id,
                                                      @RequestParam String nome,
                                                      @RequestParam String dimensao,
                                                      @RequestParam String gps);

    public ResponseEntity<Area> SalvarAlteracoes(@RequestBody Area area);

    public ResponseEntity<Area> DeletarAreaPorId(@RequestParam Long areaId);

}
