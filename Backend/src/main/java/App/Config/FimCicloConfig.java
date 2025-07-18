package App.Config;

import App.Infra.Gateway.FimCicloGateway;
import App.Infra.UseCase.FimCiclo.UseCaseFimCicloDelete;
import App.Infra.UseCase.FimCiclo.UseCaseFimCicloGet;
import App.Infra.UseCase.FimCiclo.UseCaseFimCicloPost;
import App.Infra.UseCase.FimCiclo.UseCaseFimCicloPut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FimCicloConfig {

    @Bean
    UseCaseFimCicloGet useCaseFimCicloGet(FimCicloGateway fimCicloGateway)
    {return new UseCaseFimCicloGet(fimCicloGateway);}

    @Bean
    UseCaseFimCicloPost useCaseFimCicloPost(FimCicloGateway fimCicloGateway)
    {return new UseCaseFimCicloPost(fimCicloGateway);}

    @Bean
    UseCaseFimCicloPut useCaseFimCicloPut(FimCicloGateway fimCicloGateway)
    {return new UseCaseFimCicloPut(fimCicloGateway);}

    @Bean
    UseCaseFimCicloDelete useCaseFimCicloDelete(FimCicloGateway fimCicloGateway)
    {return new UseCaseFimCicloDelete(fimCicloGateway);}
}
