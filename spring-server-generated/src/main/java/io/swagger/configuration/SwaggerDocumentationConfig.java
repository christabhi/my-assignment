package io.swagger.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-23T04:43:46.613Z[GMT]")
@Configuration
public class SwaggerDocumentationConfig {

	@Bean
	public Docket customImplementation() {
		return new Docket(DocumentationType.OAS_30).select().apis(RequestHandlerSelectors.basePackage("io.swagger.api"))
				.build().directModelSubstitute(org.threeten.bp.LocalDate.class, java.sql.Date.class)
				.directModelSubstitute(org.threeten.bp.OffsetDateTime.class, java.util.Date.class).apiInfo(apiInfo());
	}

	ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("CG Assignment").description(
				"This is an assignment for Account Balance. For this sample, you can use the api key `special-key` to test the authorization     filters.")
				.license("Apache 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
				.termsOfServiceUrl("").version("1.0.0").contact(new Contact("", "", "")).build();
	}

	@Bean
	public OpenAPI openApi() {
		return new OpenAPI().info(new Info().title("CG Assignment").description(
				"This is an assignment for Account Balance. For this sample, you can use the api key `special-key` to test the authorization     filters.")
				.termsOfService("").version("1.0.0")
				.license(new License().name("Apache 2.0").url("http://www.apache.org/licenses/LICENSE-2.0.html"))
				.contact(new io.swagger.v3.oas.models.info.Contact().email("")));
	}

}
