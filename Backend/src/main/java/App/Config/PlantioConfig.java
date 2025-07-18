package App.Config;

import App.Infra.Gateway.PlantioGateway;
import App.Infra.UseCase.Plantio.UseCasePlantioDelete;
import App.Infra.UseCase.Plantio.UseCasePlantioGet;
import App.Infra.UseCase.Plantio.UseCasePlantioPost;
import App.Infra.UseCase.Plantio.UseCasePlantioPut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlantioConfig {

    @Bean
    UseCasePlantioGet useCasePlantioGet(PlantioGateway plantioGateway)
    { return new UseCasePlantioGet(plantioGateway);}

    @Bean
    UseCasePlantioPost useCasePlantioPost(PlantioGateway plantioGateway)
    {return new UseCasePlantioPost(plantioGateway);}

    @Bean
    UseCasePlantioPut useCasePlantioPut(PlantioGateway plantioGateway)
    { return new UseCasePlantioPut(plantioGateway);}

    @Bean
    UseCasePlantioDelete useCasePlantioDelete(PlantioGateway plantioGateway)
    {return new UseCasePlantioDelete(plantioGateway);}

}
