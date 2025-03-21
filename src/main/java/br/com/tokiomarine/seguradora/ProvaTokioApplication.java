package br.com.tokiomarine.seguradora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableAutoConfiguration
@EntityScan(basePackages = { "br.com.tokiomarine.seguradora.infrastructure.entities" })
@ComponentScan( basePackages = {"br.com.tokiomarine.seguradora.*"})
@EnableJpaRepositories(basePackages = {"br.com.tokiomarine.seguradora.infrastructure.repositories"})
@EnableTransactionManagement
@Configuration
@EnableSwagger2
@SpringBootApplication
public class ProvaTokioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProvaTokioApplication.class, args);
	}
	
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
          .select()
          .apis(RequestHandlerSelectors.any())
          .paths(PathSelectors.any())
          .build();
    }

}
