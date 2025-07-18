package App.Infra.UseCase.Mensagem;

import App.Infra.Gateway.MensagemGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseMensagemPost {

    private final MensagemGateway mensagemGateway;

    public UseCaseMensagemPost(MensagemGateway mensagemGateway) {
        this.mensagemGateway = mensagemGateway;
    }

    public String setIdentificadorPlantio(@RequestParam String identificador)
    { return mensagemGateway.setIdentificadorPlantio(identificador);}

    public ResponseEntity<Void> SetMensangem(@RequestParam String identificadorPlantio,
                                             @RequestParam String mensagem)
    {return mensagemGateway.SetMensangem(identificadorPlantio, mensagem);}
}
