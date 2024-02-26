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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author : Prakash Karki
 * @Purpose : EnrolmentRequest | request for enrolment 
 * @Created : 25 Feb 2024 9:38:59 pm
 */
@ApiModel(value = "EnrolmentRequest")
public class EnrolmentRequest {
	
	@ApiModelProperty(value = "studentId", required = false)
	private String studentId;

	@ApiModelProperty(value = "studentName", required = true)
	private String studentName;
	
	@ApiModelProperty(value = "studentAge", required = true)
	private String studentAge;
	
	@ApiModelProperty(value = "course", required = true)
	private String course;

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
	 * @return the course
	 */
	public String getCourse() {
		return course;
	}

	/**
	 * @param course the course to set
	 */
	public void setCourse(String course) {
		this.course = course;
	}
}
