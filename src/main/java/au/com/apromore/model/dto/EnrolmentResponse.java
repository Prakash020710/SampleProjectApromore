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
package au.com.apromore.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author : Prakash Karki
 * @Purpose : EnrolmentResponse | response class
 * @Created : 25 Feb 2024 10:11:18 pm
 */
@JsonInclude(Include.NON_NULL)
public class EnrolmentResponse {
	
	private String studentId;
	
	private String enrolmentId;

	private Error error;

	/**
	 * @return the studentId
	 */
	public String getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	/**
	 * @return the enrolmentId
	 */
	public String getEnrolmentId() {
		return enrolmentId;
	}

	/**
	 * @param enrolmentId the enrolmentId to set
	 */
	public void setEnrolmentId(String enrolmentId) {
		this.enrolmentId = enrolmentId;
	}

	/**
	 * @return the error
	 */
	public Error getError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(Error error) {
		this.error = error;
	}
}
