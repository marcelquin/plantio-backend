package App.Config;

import App.Infra.Gateway.MensagemGateway;
import App.Infra.UseCase.Mensagem.UseCaseMensagemPost;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MensagemConfig {

    @Bean
    UseCaseMensagemPost useCaseMensagemPost(MensagemGateway mensagemGateway)
    {return new UseCaseMensagemPost(mensagemGateway);}
}
