package App.Api;

import App.Domain.Bussness.PlantioService;
import App.Domain.Response.Area;
import App.Domain.Response.Plantio;
import App.Infra.UseCase.Plantio.UseCasePlantioDelete;
import App.Infra.UseCase.Plantio.UseCasePlantioGet;
import App.Infra.UseCase.Plantio.UseCasePlantioPost;
import App.Infra.UseCase.Plantio.UseCasePlantioPut;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hibernate.annotations.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("plantio")
@Tag(name = "Plantio", description = "Manipula dados relacioados a entidade")
@CrossOrigin(origins = "*")
public class PlantioController {

    private final UseCasePlantioGet casePlantioGet;
    private final UseCasePlantioPut casePlantioPut;
    private final UseCasePlantioPost casePlantioPost;
    private final UseCasePlantioDelete casePlantioDelete;

    public PlantioController(UseCasePlantioGet casePlantioGet, UseCasePlantioPut casePlantioPut, UseCasePlantioPost casePlantioPost, UseCasePlantioDelete casePlantioDelete) {
        this.casePlantioGet = casePlantioGet;
        this.casePlantioPut = casePlantioPut;
        this.casePlantioPost = casePlantioPost;
        this.casePlantioDelete = casePlantioDelete;
    }


    @Operation(summary = "Lista Registros da tabela", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("ListarPlantio")
    public ResponseEntity<List<Plantio>> ListarPlantio()
    {return casePlantioGet.ListarPlantio();}


    @Operation(summary = "Salva Registro na tabela", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PostMapping("NovoPlantio")
    public ResponseEntity<Plantio> NovoPlantio(@RequestParam Long areaId)
    {return casePlantioPost.NovoPlantio(areaId);}

    @Operation(summary = "Edita Registro da tabela adicionando entidades", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PutMapping("NovaAdubacao")
    public ResponseEntity<Plantio> NovaAdubacao(@RequestParam Long id,
                                                @RequestParam String relatorio)
    {return casePlantioPut.NovaAdubacao(id, relatorio);}

    @Operation(summary = "Deleta registro da tabela", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @DeleteMapping("DeletarPlantioPorId")
    public ResponseEntity<Void> DeletarPlantioPorId(@RequestParam Long plantioId)
    {return casePlantioDelete.DeletarPlantioPorId(plantioId); }

}
