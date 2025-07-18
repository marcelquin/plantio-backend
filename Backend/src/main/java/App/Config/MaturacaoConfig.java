package App.Config;

import App.Infra.Gateway.MaturacaoCicloGateway;
import App.Infra.UseCase.MaturacaoCiclo.UseCaseMaturacaoCicloDelete;
import App.Infra.UseCase.MaturacaoCiclo.UseCaseMaturacaoCicloGet;
import App.Infra.UseCase.MaturacaoCiclo.UseCaseMaturacaoCicloPost;
import App.Infra.UseCase.MaturacaoCiclo.UseCaseMaturacaoCicloPut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MaturacaoConfig {

    @Bean
    UseCaseMaturacaoCicloGet useCaseMaturacaoCicloGet(MaturacaoCicloGateway maturacaoCicloGateway)
    {return new UseCaseMaturacaoCicloGet(maturacaoCicloGateway);}

    @Bean
    UseCaseMaturacaoCicloPost useCaseMaturacaoCicloPost(MaturacaoCicloGateway maturacaoCicloGateway)
    {return new UseCaseMaturacaoCicloPost(maturacaoCicloGateway);}

    @Bean
    UseCaseMaturacaoCicloPut useCaseMaturacaoCicloPut(MaturacaoCicloGateway maturacaoCicloGateway)
    {return new UseCaseMaturacaoCicloPut(maturacaoCicloGateway);}

    @Bean
    UseCaseMaturacaoCicloDelete useCaseMaturacaoCicloDelete(MaturacaoCicloGateway maturacaoCicloGateway)
    {return new UseCaseMaturacaoCicloDelete(maturacaoCicloGateway);}
}
