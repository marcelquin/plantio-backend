package App.Config;

import App.Infra.Gateway.LocalizacaoGateway;
import App.Infra.UseCase.Localizacao.UseCaseLocalizacaoDelete;
import App.Infra.UseCase.Localizacao.UseCaseLocalizacaoGet;
import App.Infra.UseCase.Localizacao.UseCaseLocalizacaoPost;
import App.Infra.UseCase.Localizacao.UseCaseLocalizacaoPut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocalizacaoConfig {

    @Bean
    UseCaseLocalizacaoGet useCaseLocalizacaoGet(LocalizacaoGateway localizacaoGateway)
    {return new UseCaseLocalizacaoGet(localizacaoGateway);}

    @Bean
    UseCaseLocalizacaoPost useCaseLocalizacaoPost(LocalizacaoGateway localizacaoGateway)
    {return new UseCaseLocalizacaoPost(localizacaoGateway);}

    @Bean
    UseCaseLocalizacaoPut useCaseLocalizacaoPut(LocalizacaoGateway localizacaoGateway)
    {return new UseCaseLocalizacaoPut(localizacaoGateway);}

    @Bean
    UseCaseLocalizacaoDelete useCaseLocalizacaoDelete(LocalizacaoGateway localizacaoGateway)
    {return new UseCaseLocalizacaoDelete(localizacaoGateway);}

}
