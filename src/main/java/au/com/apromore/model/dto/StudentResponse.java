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
 * @Purpose : StudentResponse | Student Response class
 * @Created : 25 Feb 2024 10:08:47 am
 */
@JsonInclude(Include.NON_NULL)
public class StudentResponse {

	private String studentId;
	
	private String studentName;
	
	private String studentAge;
	
	private String courseEnroled;
	
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
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * @return the studentAge
	 */
	public String getStudentAge() {
		return studentAge;
	}

	/**
	 * @param studentAge the studentAge to set
	 */
	public void setStudentAge(String studentAge) {
		this.studentAge = studentAge;
	}

	/**
	 * @return the courseEnroled
	 */
	public String getCourseEnroled() {
		return courseEnroled;
	}

	/**
	 * @param courseEnroled the courseEnroled to set
	 */
	public void setCourseEnroled(String courseEnroled) {
		this.courseEnroled = courseEnroled;
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
