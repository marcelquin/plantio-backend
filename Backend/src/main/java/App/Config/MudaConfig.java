package App.Config;

import App.Infra.Gateway.MudaCicloGateway;
import App.Infra.UseCase.MudaCiclo.UseCaseMudaCicloDelete;
import App.Infra.UseCase.MudaCiclo.UseCaseMudaCicloGet;
import App.Infra.UseCase.MudaCiclo.UseCaseMudaCicloPost;
import App.Infra.UseCase.MudaCiclo.UseCaseMudaCicloPut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MudaConfig {

    @Bean
    UseCaseMudaCicloGet useCaseMudaCicloGet(MudaCicloGateway mudaCicloGateway)
    {return new UseCaseMudaCicloGet(mudaCicloGateway);}

    @Bean
    UseCaseMudaCicloPost useCaseMudaCicloPost(MudaCicloGateway mudaCicloGateway)
    {return new UseCaseMudaCicloPost(mudaCicloGateway);}

    @Bean
    UseCaseMudaCicloPut useCaseMudaCicloPut(MudaCicloGateway mudaCicloGateway)
    {return new UseCaseMudaCicloPut(mudaCicloGateway);}

    @Bean
    UseCaseMudaCicloDelete useCaseMudaCicloDelete(MudaCicloGateway mudaCicloGateway)
    {return new UseCaseMudaCicloDelete(mudaCicloGateway);}

}
