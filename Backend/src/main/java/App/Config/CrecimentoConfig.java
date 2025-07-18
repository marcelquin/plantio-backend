package App.Config;

import App.Infra.Gateway.CrecimentoCicloGateway;
import App.Infra.UseCase.Crecimento.UseCaseCrecimentoCicloDelete;
import App.Infra.UseCase.Crecimento.UseCaseCrecimentoCicloGet;
import App.Infra.UseCase.Crecimento.UseCaseCrecimentoCicloPost;
import App.Infra.UseCase.Crecimento.UseCaseCrecimentoCicloPut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CrecimentoConfig {

    @Bean
    UseCaseCrecimentoCicloGet useCaseCrecimentoCicloGet(CrecimentoCicloGateway crecimentoCicloGateway)
    {return new UseCaseCrecimentoCicloGet(crecimentoCicloGateway);}

    @Bean
    UseCaseCrecimentoCicloPost useCaseCrecimentoCicloPost(CrecimentoCicloGateway crecimentoCicloGateway)
    {return new UseCaseCrecimentoCicloPost(crecimentoCicloGateway);}

    @Bean
    UseCaseCrecimentoCicloPut useCaseCrecimentoCicloPut(CrecimentoCicloGateway crecimentoCicloGateway)
    {return new UseCaseCrecimentoCicloPut(crecimentoCicloGateway);}

    @Bean
    UseCaseCrecimentoCicloDelete useCaseCrecimentoCicloDelete(CrecimentoCicloGateway crecimentoCicloGateway)
    {return new UseCaseCrecimentoCicloDelete(crecimentoCicloGateway);}
}
