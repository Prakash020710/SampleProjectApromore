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
package au.com.apromore.exception;

import org.springframework.http.HttpStatus;

import au.com.apromore.common.CommonConstants;
import au.com.apromore.model.dto.Error;
import au.com.apromore.model.dto.EnrolmentResponse;
import au.com.apromore.model.dto.StudentResponse;

/**
 * @author : Prakash Karki
 * @Purpose : APMException | Exception class 
 * @Created : 25 Feb 2024 10:56:13 pm
 */
public class APMException extends Exception {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 5617844240106285493L;

	private final String errorCode;

	public APMException(){
		super();
		this.errorCode = CommonConstants.DEFAULT_ERROR_CODE;
	}

	public APMException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * This method build error response for Order.
	 * @return OrderResponse
	 */
	public EnrolmentResponse buildErrorResponse() {

		EnrolmentResponse response = new EnrolmentResponse();
		Error error = new Error();
		error.setErrorId(this.errorCode);
		error.setErrorMessage(this.getMessage());
		response.setError(error);

		return response;
	}


	public StudentResponse buildStudentErrorResponse() {

		StudentResponse response = new StudentResponse();
		Error error = new Error();
		error.setErrorId(this.errorCode);
		error.setErrorMessage(this.getMessage());
		response.setError(error);

		return response;
	}

	/**
	 * This method returns the status code for the exception
	 * @return Http Status code
	 */
	public HttpStatus getStatusCode() {
		if(this.errorCode.equals(CommonConstants.APM_001) || 
				this.errorCode.equals(CommonConstants.APM_002))
			return HttpStatus.BAD_REQUEST;
		else if(this.errorCode.equals(CommonConstants.APM_003) ||
				this.errorCode.equals(CommonConstants.APM_004) || 
				this.errorCode.equals(CommonConstants.APM_005))
			return HttpStatus.NOT_FOUND;
		else
			return HttpStatus.INTERNAL_SERVER_ERROR;
	}
}
