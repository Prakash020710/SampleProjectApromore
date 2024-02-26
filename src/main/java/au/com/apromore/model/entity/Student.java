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
 * @Purpose : Student | Entity for Student table.
 * @Created : 25 Feb 2024 9:37:37 pm
 */
@Entity
@Table(name = "STUDENT")
public class Student {

	@Id
	private String studentId;

	@Column(name = "student_name")
	private String studentName;

	@Column(name = "student_age")
	private String studentAge;

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

}
