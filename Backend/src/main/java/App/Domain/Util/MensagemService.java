package App.Domain.Util;

import App.Domain.Response.Planta;
import App.Domain.Response.Plantio;
import App.Infra.Exceptions.NullargumentsException;
import App.Infra.Gateway.MensagemGateway;
import App.Infra.UseCase.Plantio.UseCasePlantioGet;
import App.Infra.UseCase.Plantio.UseCasePlantioPut;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MensagemService implements MensagemGateway {

    private final UseCasePlantioGet useCasePlantioGet;
    private final UseCasePlantioPut useCasePlantioPut;

    public MensagemService(UseCasePlantioGet useCasePlantioGet, UseCasePlantioPut useCasePlantioPut) {
        this.useCasePlantioGet = useCasePlantioGet;
        this.useCasePlantioPut = useCasePlantioPut;
    }

    @Override
    public String setIdentificadorPlantio(String identificador)
    {
        try
        {
            if(identificador == null){throw new NullargumentsException();}
            String[] partes = identificador.split(":");
            String plantio = partes[0];
            return plantio;
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return null;
    }

    @Override
    public ResponseEntity<Void> SetMensangem(String identificadorPlantio, String mensagem)
    {
        try
        {
            if(identificadorPlantio == null){throw new NullargumentsException();}
            if(mensagem == null){throw new NullargumentsException();}
            Plantio plantio = useCasePlantioGet.BuscarPlantioPorIdentificador(identificadorPlantio).getBody();
            plantio.getNotificacoes().add(mensagem);
            plantio.setTimeStamp(LocalDateTime.now());
            useCasePlantioPut.SalarAlteracao(plantio);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
