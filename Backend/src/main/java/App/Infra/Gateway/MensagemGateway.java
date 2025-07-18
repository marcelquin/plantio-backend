package App.Infra.Gateway;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public interface MensagemGateway {

    public String setIdentificadorPlantio(@RequestParam String identificador);

    public ResponseEntity<Void> SetMensangem(@RequestParam String identificadorPlantio,
                                             @RequestParam String mensagem);

}
