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
package au.com.apromore.controller;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.InputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import au.com.apromore.SampleProjectApromoreApplication;
import au.com.apromore.model.dto.EnrolmentRequest;

/**
 * @author : Prakash Karki
 * @Purpose : ApromoreAssessmentServiceTest | Test class for main APIs
 * @Created : 26 Feb 2024 11:20:34 pm
 */
@RunWith(SpringRunner.class)
@SpringBootTest(value = "spring.profiles.active=h2", classes = SampleProjectApromoreApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ContextConfiguration
public class APMAssessmentServiceTest {

	private static final Logger logger = LogManager.getLogger(APMAssessmentServiceTest.class);

	private EnrolmentRequest enrolmentRequest1, enrolmentRequest2, enrolmentRequest3;

	private ObjectMapper mapper;

	@Autowired
	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception{
		mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		mapper.configure(SerializationFeature.WRITE_ENUMS_USING_INDEX, false);

		TypeReference<EnrolmentRequest> typeReference = new TypeReference<EnrolmentRequest>() {
		};
		InputStream is1 = TypeReference.class.getResourceAsStream("/json/EnrolmentRequest1.json");
		enrolmentRequest1 = mapper.readValue(is1, typeReference);

		InputStream is2 = TypeReference.class.getResourceAsStream("/json/EnrolmentRequest2.json");
		enrolmentRequest2 = mapper.readValue(is2, typeReference);

		InputStream is3 = TypeReference.class.getResourceAsStream("/json/EnrolmentRequest2.json");
		enrolmentRequest3 = mapper.readValue(is3, typeReference);
	}

	@Test
	public void testEnrolment_With_Valid_Request_Success() {

		try {
			this.mockMvc.perform(post("/v1/enrolment")
					.header("Authorization", "Bearer Test")
					.contentType(MediaType.APPLICATION_JSON)
					.content(mapper.writeValueAsString(enrolmentRequest1)))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(status().isAccepted());

		} catch (JsonProcessingException e) {
			logger.error(e);
			fail(e.getMessage());
		} catch (Exception e) {
			logger.error(e);
			fail(e.getMessage());
		}
	}

	@Test
	public void testEnrolment_With_InvalidCourse_Fail() {

		try {
			this.mockMvc.perform(post("/v1/enrolment")
					.header("Authorization", "Bearer Test")
					.contentType(MediaType.APPLICATION_JSON)
					.content(mapper.writeValueAsString(enrolmentRequest2)))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(status().isBadRequest());

		} catch (JsonProcessingException e) {
			logger.error(e);
			fail(e.getMessage());
		} catch (Exception e) {
			logger.error(e);
			fail(e.getMessage());
		}
	}

	@Test
	public void testEnrolment_With_Invalid_Age_Fail() {

		try {
			this.mockMvc.perform(post("/v1/enrolment")
					.header("Authorization", "Bearer Test")
					.contentType(MediaType.APPLICATION_JSON)
					.content(mapper.writeValueAsString(enrolmentRequest3)))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(status().isBadRequest());

		} catch (JsonProcessingException e) {
			logger.error(e);
			fail(e.getMessage());
		} catch (Exception e) {
			logger.error(e);
			fail(e.getMessage());
		}
	}

	@Test
	public void testGet_Enrolment_For_Student_Success() {

		try {
			MvcResult result = this.mockMvc.perform(post("/v1/enrolment")
					.header("Authorization", "Bearer Test")
					.contentType(MediaType.APPLICATION_JSON)
					.content(mapper.writeValueAsString(enrolmentRequest1)))
					.andDo(MockMvcResultHandlers.print())
					.andExpect(status().isAccepted())
					.andReturn();

			String response = result.getResponse().getContentAsString();
			JsonNode jsonNode = mapper.readTree(response);
			String studentId = jsonNode.get("studentId").textValue();

			this.mockMvc.perform(get("/v1/enrolment/" + studentId)
					.header("Authorization", "Bearer Test"))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(status().isOk());

		} catch (JsonProcessingException e) {
			logger.error(e);
			fail(e.getMessage());
		} catch (Exception e) {
			logger.error(e);
			fail(e.getMessage());
		}
	}

	@Test
	public void testGet_Enrolment_For_Student_Fail() {

		try {
			this.mockMvc.perform(get("/v1/enrolment/test000")
					.header("Authorization", "Bearer Test"))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(status().isNotFound());

		} catch (JsonProcessingException e) {
			logger.error(e);
			fail(e.getMessage());
		} catch (Exception e) {
			logger.error(e);
			fail(e.getMessage());
		}
	}

	@Test
	public void testDelete_Enrolment_For_Student_Success() {

		try {
			MvcResult result = this.mockMvc.perform(post("/v1/enrolment")
					.header("Authorization", "Bearer Test")
					.contentType(MediaType.APPLICATION_JSON)
					.content(mapper.writeValueAsString(enrolmentRequest1)))
					.andDo(MockMvcResultHandlers.print())
					.andExpect(status().isAccepted())
					.andReturn();

			String response = result.getResponse().getContentAsString();
			JsonNode jsonNode = mapper.readTree(response);
			String studentId = jsonNode.get("studentId").textValue();

			this.mockMvc.perform(delete("/v1/enrolment/" + studentId)
					.header("Authorization", "Bearer Test"))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(status().isNoContent());

		} catch (JsonProcessingException e) {
			logger.error(e);
			fail(e.getMessage());
		} catch (Exception e) {
			logger.error(e);
			fail(e.getMessage());
		}
	}

	@Test
	public void testDelete_Enrolment_Fail() {

		try {
			this.mockMvc.perform(delete("/v1/enrolment/test000")
					.header("Authorization", "Bearer Test"))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(status().isNotFound());

		} catch (JsonProcessingException e) {
			logger.error(e);
			fail(e.getMessage());
		} catch (Exception e) {
			logger.error(e);
			fail(e.getMessage());
		}
	}
}
