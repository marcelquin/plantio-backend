package App.Api;

import App.Domain.Response.Localizacao;
import App.Infra.UseCase.Localizacao.UseCaseLocalizacaoDelete;
import App.Infra.UseCase.Localizacao.UseCaseLocalizacaoGet;
import App.Infra.UseCase.Localizacao.UseCaseLocalizacaoPost;
import App.Infra.UseCase.Localizacao.UseCaseLocalizacaoPut;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("localizacao")
@Tag(name = "Localizacao", description = "Manipula dados relacioados a entidade")
@CrossOrigin(origins = "*")
public class LocalizacaoController {

    private final UseCaseLocalizacaoGet caseLocalizacaoGet;
    private final UseCaseLocalizacaoPost caseLocalizacaoPost;
    private final UseCaseLocalizacaoDelete caseLocalizacaoDelete;

    public LocalizacaoController(UseCaseLocalizacaoGet caseLocalizacaoGet, UseCaseLocalizacaoPost caseLocalizacaoPost, UseCaseLocalizacaoDelete caseLocalizacaoDelete) {
        this.caseLocalizacaoGet = caseLocalizacaoGet;
        this.caseLocalizacaoPost = caseLocalizacaoPost;
        this.caseLocalizacaoDelete = caseLocalizacaoDelete;
    }

    @Operation(summary = "Lista Registros da tabela", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("ListarLocalizacoesDisponiveis")
    public ResponseEntity<List<Localizacao>> ListarLocalizacoesDisponiveis()
    {return caseLocalizacaoGet.ListarLocalizacoesDisponiveis();}

    @Operation(summary = "Lista Registros da tabela", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("ListarLocalizacoes")
    public ResponseEntity<List<Localizacao>> ListarLocalizacoes()
    {return caseLocalizacaoGet.ListarLocalizacoes();}

    @Operation(summary = "Lista Registros da tabela", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("ListarLocalizacoesNaoDisponiveis")
    public ResponseEntity<List<Localizacao>> ListarLocalizacoesNaoDisponiveis()
    {return caseLocalizacaoGet.ListarLocalizacoesNaoDisponiveis();}

    @Operation(summary = "Salva Registros na tabela", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PostMapping("NovaLocalizacao")
    public ResponseEntity<Localizacao> NovaLocalizacao(@RequestParam Long linhaId)
    {return caseLocalizacaoPost.NovaLocalizacao(linhaId);}

    @Operation(summary = "Deleta Registros da tabela", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @DeleteMapping("DeletarLocalizacaoPorId")
    public ResponseEntity<Localizacao> DeletarLocalizacaoPorId(@RequestParam Long localizacaoId)
    {return caseLocalizacaoDelete.DeletarLocalizacaoPorId(localizacaoId);}

}
