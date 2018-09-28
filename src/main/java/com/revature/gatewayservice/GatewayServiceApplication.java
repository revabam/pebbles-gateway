package com.revature.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableZuulProxy
@EnableEurekaClient
@EnableSwagger2
@SpringBootApplication
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);

	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.revature"))
				.paths(PathSelectors.any()).build();
	}
	
	/**
	 * This bean exists because we can not configure using mvc because Zuul does not have an @Controller 
	 * It will prevent the cors filter error (DON'T DELETE)
	 * 
	 * @return
	 * @author Alicia Douglas, Batch: 1806-spark, Trainer: Steven Kelsey
	 */
	@Bean
	public CorsFilter corsFilter() {
	   final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	   final CorsConfiguration config = new CorsConfiguration();
	   config.setAllowCredentials(true);
	   config.addAllowedOrigin("*");
	   config.addAllowedHeader("*");
	   config.addAllowedMethod("*");
	   source.registerCorsConfiguration("*", config);
	   return new CorsFilter(source);
	}
}
