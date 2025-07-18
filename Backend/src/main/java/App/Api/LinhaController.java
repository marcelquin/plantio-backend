package App.Api;

import App.Domain.Bussness.LinhaService;
import App.Domain.Response.Linha;
import App.Infra.UseCase.Linha.UseCaseLinhaDelete;
import App.Infra.UseCase.Linha.UseCaseLinhaGet;
import App.Infra.UseCase.Linha.UseCaseLinhaPost;
import App.Infra.UseCase.Linha.UseCaseLinhaPut;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("linha")
@Tag(name = "Linha", description = "Manipula dados relacioados a entidade")
@CrossOrigin(origins = "*")
public class LinhaController {

    private final UseCaseLinhaGet caseLinhaGet;
    private final UseCaseLinhaPost caseLinhaPost;
    private final UseCaseLinhaPut caseLinhaPut;
    private final UseCaseLinhaDelete caseLinhaDelete;

    public LinhaController(UseCaseLinhaGet caseLinhaGet, UseCaseLinhaPost caseLinhaPost, UseCaseLinhaPut caseLinhaPut, UseCaseLinhaDelete caseLinhaDelete) {
        this.caseLinhaGet = caseLinhaGet;
        this.caseLinhaPost = caseLinhaPost;
        this.caseLinhaPut = caseLinhaPut;
        this.caseLinhaDelete = caseLinhaDelete;
    }

    @Operation(summary = "Lista Registros da tabela", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("ListarLinhas")
    public ResponseEntity<List<Linha>> ListarLinhas()
    {return caseLinhaGet.ListarLinhas();}

    @Operation(summary = "Busca Registro na tabela por Id", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("BuscarLinhaPorId")
    public ResponseEntity<Linha> BuscarLinhaPorId(@RequestParam Long id)
    {return caseLinhaGet.BuscarLinhaPorId(id);}


    @Operation(summary = "Salva Registros na tabela", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PostMapping("NovaLinha")
    public ResponseEntity<Linha> NovaLinha(@RequestParam Long plantioId)
    {return caseLinhaPost.NovaLinha(plantioId);}

    @Operation(summary = "Deleta Registros da tabela", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @DeleteMapping("DeletarLinhaPorId")
    public ResponseEntity<Linha> DeletarLinhaPorId(@RequestParam Long linhaId)
    {return caseLinhaDelete.DeletarLinhaPorId(linhaId);}


}
