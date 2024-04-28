package kr.co.thecommerce.user.core.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class configuration {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().components(new Components())
                .info(apiInfo());
    }

    private Info apiInfo() {
        return new Info().title("The Commerce API");
    }

    @Bean
    public GroupedOpenApi getUserAPI() {
        return GroupedOpenApi.builder()
                .group("user")
                .pathsToMatch("/api/user/**")
                .build();
    }
}
