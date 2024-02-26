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
package au.com.apromore.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author : Prakash Karki
 * @Purpose : Enrolment | Entity for Enrolment table.
 * @Created : 25 Feb 2024 9:36:54 pm
 */
@Entity
@Table(name = "ENROLMENT")
public class Enrolment {

	@Id
	private String enrolmentId;

	@Column(name = "student_id")
	private String studentId;

	@Column(name = "course_code")
	private String courseCode;

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
	 * @return the courseCode
	 */
	public String getCourseCode() {
		return courseCode;
	}

	/**
	 * @param courseCode the courseCode to set
	 */
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
}
