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

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import au.com.apromore.common.CommonConstants;
import au.com.apromore.exception.APMException;
import au.com.apromore.model.dto.EnrolmentRequest;
import au.com.apromore.model.dto.EnrolmentResponse;
import au.com.apromore.model.dto.StudentResponse;
import au.com.apromore.service.APMOrchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author : Prakash Karki
 * @Purpose : APMAssessmentService | Rest controller for apis.
 * @Created : 25 Feb 2024 9:37:59 pm
 */

@RestController
@Api(value = "Apromore Assessment Service")
public class APMAssessmentService {

	@Autowired
	private APMOrchService apmOrchService;

	@ApiImplicitParams({
		@ApiImplicitParam(name = CommonConstants.AUTHORIZATION, value = CommonConstants.AUTHORIZATION_TOKEN, dataType = "string", paramType = "header", required = true),
		@ApiImplicitParam(name = CommonConstants.X_CORRELATION_ID, dataType = "string", paramType = "header", required = false
				)
	})
	@ApiResponses(value = {
			@ApiResponse(code = 202, message = "Successfully Created"),
			@ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 429, message = "Request limit reached"),
			@ApiResponse(code = 500, message = "Internal server error"),
			@ApiResponse(code = 503, message = "Service unavailable")
	})
	@PostMapping(value = "v1/enrolment")
	public ResponseEntity<EnrolmentResponse> processEnrolment (@Valid @RequestBody EnrolmentRequest request){

		EnrolmentResponse response = null;
		try {
			response = apmOrchService.processEnrolment(request);
		}catch(APMException apme) {
			return new ResponseEntity<>(apme.buildErrorResponse(), apme.getStatusCode());
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

	}

	@ApiImplicitParams({
		@ApiImplicitParam(name = CommonConstants.AUTHORIZATION, value = CommonConstants.AUTHORIZATION_TOKEN, dataType = "string", paramType = "header", required = true),
		@ApiImplicitParam(name = CommonConstants.X_CORRELATION_ID, dataType = "string", paramType = "header", required = false
				)
	})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 429, message = "Request limit reached"),
			@ApiResponse(code = 500, message = "Internal server error"),
			@ApiResponse(code = 503, message = "Service unavailable")
	})
	@GetMapping(value = "v1/enrolment/{studentId}")
	public ResponseEntity<StudentResponse> getStudent (@PathVariable String studentId){

		try {
			return new ResponseEntity<>(apmOrchService.getStudentDetails(studentId), HttpStatus.OK);
		} catch (APMException apme) {
			return new ResponseEntity<>(apme.buildStudentErrorResponse(), apme.getStatusCode());
		}

	}

	@ApiImplicitParams({
		@ApiImplicitParam(name = CommonConstants.AUTHORIZATION, value = CommonConstants.AUTHORIZATION_TOKEN, dataType = "string", paramType = "header", required = true),
		@ApiImplicitParam(name = CommonConstants.X_CORRELATION_ID, dataType = "string", paramType = "header", required = false
				)
	})
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 429, message = "Request limit reached"),
			@ApiResponse(code = 500, message = "Internal server error"),
			@ApiResponse(code = 503, message = "Service unavailable")
	})
	@DeleteMapping(value = "v1/enrolment/{studentId}")
	public ResponseEntity<StudentResponse> deleteStudent (@PathVariable String studentId){

		try {
			apmOrchService.deleteStudent(studentId);
		} catch (APMException apme) {
			return new ResponseEntity<>(apme.buildStudentErrorResponse(), apme.getStatusCode());
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}
}
