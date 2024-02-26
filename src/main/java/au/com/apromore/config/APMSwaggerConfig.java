/**
 *=================================================================
 * Copyright (c) Sample 2024
 *=================================================================
 * (C) 2024 All rights reserved. This product and related documents
 * are protected by copyright restricting its use, copying, 
 * distribution and decompilation. No part of this product or 
 * related documentation can be reproduced in any form by any 
 * means without prior written authorisation.
 *
 * This class is for Apromore Sample Assessment.
 */
package au.com.apromore.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author : Prakash Karki
 * @Purpose : APMSwaggerConfig | Swagger configuration class
 * @Created : 25 Feb 2024 10:16:36 pm
 */

@Configuration
@EnableSwagger2
public class APMSwaggerConfig {

	@Bean
	public Docket api() { 
		return new Docket(DocumentationType.SWAGGER_2)  
				.select()                                  
				.apis(RequestHandlerSelectors.basePackage("au.com.apromore.controller"))              
				.paths(PathSelectors.any())                          
				.build()
				.apiInfo(apiInfo());                                           
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Apromore Assessment Service", 
				"These Apis are created as part of requirement listed in assessment.", 
				"v1.0", 
				"Terms of Service", 
				new Contact("Solution Design Team", "Solution Design Url", "Sample.email@gmail.com"), 
				"Sample API", 
				"Sample License Url", 
				Collections.emptyList());
	}
}
