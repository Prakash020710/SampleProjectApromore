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

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 * @author : Prakash Karki
 * @Purpose : APMSecurityConfig | Security Config class
 * @Created : 25 Feb 2024 10:56:15 pm
 */
@Configuration
@EnableWebSecurity
public class APMSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	public void configure(WebSecurity web) {

		web.ignoring().anyRequest();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		List<String> permitAllEndpointList = Arrays.asList("/v1/**",
				"swagger-ui.html");
		http
		.authorizeRequests()
		.antMatchers(permitAllEndpointList.toArray(new String[permitAllEndpointList.size()]))
		.permitAll();
	}

}
