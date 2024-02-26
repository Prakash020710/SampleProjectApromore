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
 * @Purpose : Course | Entity for Course table.
 * @Created : 25 Feb 2024 9:37:05 pm
 */
@Entity
@Table(name = "COURSE")
public class Course {
	
	@Id
	private String courseCode;
	
	@Column(name = "course_name")
	private String courseName;
	
	@Column(name = "description")
	private String description;

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

	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
