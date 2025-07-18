package App.Config;

import App.Infra.Gateway.LinhaGateway;
import App.Infra.UseCase.Linha.UseCaseLinhaDelete;
import App.Infra.UseCase.Linha.UseCaseLinhaGet;
import App.Infra.UseCase.Linha.UseCaseLinhaPost;
import App.Infra.UseCase.Linha.UseCaseLinhaPut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LinhaConfig {

    @Bean
    UseCaseLinhaGet useCaseLinhaGet(LinhaGateway linhaGateway)
    {return new UseCaseLinhaGet(linhaGateway);}

    @Bean
    UseCaseLinhaPost useCaseLinhaPost(LinhaGateway linhaGateway)
    {return new UseCaseLinhaPost(linhaGateway);}

    @Bean
    UseCaseLinhaPut useCaseLinhaPut(LinhaGateway linhaGateway)
    {return new UseCaseLinhaPut(linhaGateway);}

    @Bean
    UseCaseLinhaDelete useCaseLinhaDelete(LinhaGateway linhaGateway)
    {return new UseCaseLinhaDelete(linhaGateway);}
}
