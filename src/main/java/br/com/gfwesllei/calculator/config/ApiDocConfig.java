package br.com.gfwesllei.calculator.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("swagger")
public class ApiDocConfig {

  @Value("${springdoc.title}")
  private String title;
  @Value("${springdoc.description}")
  private String description;
  @Value("${springdoc.version}")
  private String version;

  @Bean
  OpenAPI customOpenApi() {
    return new OpenAPI().info(
        new Info().title(title).version(version).description(description));
  }
}
