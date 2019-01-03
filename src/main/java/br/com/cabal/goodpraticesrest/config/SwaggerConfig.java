package br.com.cabal.goodpraticesrest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Value("${version.number}")
    private String versionNumber;

    @Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("br.com.cabal.goodpraticesrest.controller"))
				.paths(regex("/.*")).build().apiInfo(metaData());
	}
	
	private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfoBuilder().title("Good Pratices Rest")
        									  .description("Good Pratices Rest")
        									  .version(this.versionNumber)
        									  .termsOfServiceUrl("urn:tos")
        									  .contact(new Contact("", "", ""))
        									  .license("Apache 2.0")
        									  .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
        									  .build();
        return apiInfo;
    }	
}