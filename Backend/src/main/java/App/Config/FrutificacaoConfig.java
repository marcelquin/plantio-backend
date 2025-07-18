package App.Config;

import App.Infra.Gateway.FrutificacaoCicloGateway;
import App.Infra.UseCase.FrutificacaoCiclo.UseCaseFrutificacaoCicloDelete;
import App.Infra.UseCase.FrutificacaoCiclo.UseCaseFrutificacaoCicloGet;
import App.Infra.UseCase.FrutificacaoCiclo.UseCaseFrutificacaoCicloPost;
import App.Infra.UseCase.FrutificacaoCiclo.UseCaseFrutificacaoCicloPut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FrutificacaoConfig {

    @Bean
    UseCaseFrutificacaoCicloGet useCaseFrutificacaoCicloGet(FrutificacaoCicloGateway frutificacaoCicloGateway)
    {return new UseCaseFrutificacaoCicloGet(frutificacaoCicloGateway);}

    @Bean
    UseCaseFrutificacaoCicloPost useCaseFrutificacaoCicloPost(FrutificacaoCicloGateway frutificacaoCicloGateway)
    {return new UseCaseFrutificacaoCicloPost(frutificacaoCicloGateway);}

    @Bean
    UseCaseFrutificacaoCicloPut useCaseFrutificacaoCicloPut(FrutificacaoCicloGateway frutificacaoCicloGateway)
    {return new UseCaseFrutificacaoCicloPut(frutificacaoCicloGateway);}

    @Bean
    UseCaseFrutificacaoCicloDelete useCaseFrutificacaoCicloDelete(FrutificacaoCicloGateway frutificacaoCicloGateway)
    {return new UseCaseFrutificacaoCicloDelete(frutificacaoCicloGateway);}
}
