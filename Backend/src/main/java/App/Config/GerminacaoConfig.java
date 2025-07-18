package App.Config;

import App.Infra.Gateway.GerminacaoCicloGateway;
import App.Infra.UseCase.GerminacaoCiclo.UseCaseGerminacaoCicloDelete;
import App.Infra.UseCase.GerminacaoCiclo.UseCaseGerminacaoCicloGet;
import App.Infra.UseCase.GerminacaoCiclo.UseCaseGerminacaoCicloPost;
import App.Infra.UseCase.GerminacaoCiclo.UseCaseGerminacaoCicloPut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GerminacaoConfig {

    @Bean
    UseCaseGerminacaoCicloGet useCaseGerminacaoCicloGet(GerminacaoCicloGateway germinacaoCicloGateway)
    {return new UseCaseGerminacaoCicloGet(germinacaoCicloGateway);}

    @Bean
    UseCaseGerminacaoCicloPost useCaseGerminacaoCicloPost(GerminacaoCicloGateway germinacaoCicloGateway)
    {return new UseCaseGerminacaoCicloPost(germinacaoCicloGateway);}

    @Bean
    UseCaseGerminacaoCicloPut useCaseGerminacaoCicloPut(GerminacaoCicloGateway germinacaoCicloGateway)
    {return new UseCaseGerminacaoCicloPut(germinacaoCicloGateway);}

    @Bean
    UseCaseGerminacaoCicloDelete useCaseGerminacaoCicloDelete(GerminacaoCicloGateway germinacaoCicloGateway)
    {return new UseCaseGerminacaoCicloDelete(germinacaoCicloGateway);}
}
