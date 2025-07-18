package App.Config;

import App.Infra.Gateway.FloracaoCicloGateway;
import App.Infra.UseCase.FloracaoCiclo.UseCaseFloracaoCicloDelete;
import App.Infra.UseCase.FloracaoCiclo.UseCaseFloracaoCicloGet;
import App.Infra.UseCase.FloracaoCiclo.UseCaseFloracaoCicloPost;
import App.Infra.UseCase.FloracaoCiclo.UseCaseFloracaoCicloPut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FloracaoConfig {

    @Bean
    UseCaseFloracaoCicloGet useCaseFlocacaoCicloGet(FloracaoCicloGateway floracaoCicloGateway)
    {return new UseCaseFloracaoCicloGet(floracaoCicloGateway);}

    @Bean
    UseCaseFloracaoCicloPost useCaseFlocacaoCicloPost(FloracaoCicloGateway floracaoCicloGateway)
    {return new UseCaseFloracaoCicloPost(floracaoCicloGateway);}

    @Bean
    UseCaseFloracaoCicloPut useCaseFlocacaoCicloPut(FloracaoCicloGateway floracaoCicloGateway)
    {return new UseCaseFloracaoCicloPut(floracaoCicloGateway);}

    @Bean
    UseCaseFloracaoCicloDelete useCaseFlocacaoCicloDelete(FloracaoCicloGateway floracaoCicloGateway)
    {return new UseCaseFloracaoCicloDelete(floracaoCicloGateway);}
}
