package App.Config;

import App.Infra.Gateway.CicloGateway;
import App.Infra.UseCase.Ciclo.UseCaseCicloDelete;
import App.Infra.UseCase.Ciclo.UseCaseCicloGet;
import App.Infra.UseCase.Ciclo.UseCaseCicloPost;
import App.Infra.UseCase.Ciclo.UseCaseCicloPut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CicloConfig {

    @Bean
    UseCaseCicloGet useCaseCicloGet(CicloGateway cicloGateway)
    {return new UseCaseCicloGet(cicloGateway);}

    @Bean
    UseCaseCicloPost useCaseCicloPost(CicloGateway cicloGateway)
    {return new UseCaseCicloPost(cicloGateway);}

    @Bean
    UseCaseCicloPut useCaseCicloPut(CicloGateway cicloGateway)
    {return new UseCaseCicloPut(cicloGateway);}

    @Bean
    UseCaseCicloDelete useCaseCicloDelete(CicloGateway cicloGateway)
    {return new UseCaseCicloDelete(cicloGateway);}

}
