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
package au.com.apromore.service;

import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.apromore.common.CommonConstants;
import au.com.apromore.common.CommonUtil;
import au.com.apromore.config.APMErrorConfig;
import au.com.apromore.exception.APMException;
import au.com.apromore.model.dto.EnrolmentRequest;
import au.com.apromore.model.dto.EnrolmentResponse;
import au.com.apromore.model.dto.StudentResponse;
import au.com.apromore.model.entity.Course;
import au.com.apromore.model.entity.Enrolment;
import au.com.apromore.model.entity.Student;

/**
 * @author : Prakash Karki
 * @Purpose : APMOrchService | Main service class for processing.
 * @Created : 25 Feb 2024 10:26:45 pm
 */
@Service
public class APMOrchService {

	private static final Logger logger = LogManager.getLogger(APMOrchService.class);

	@Autowired
	private APMDBService apmDBService;

	/**
	 * This method validates request and creates a 
	 * new record in database if request is valid.
	 * If student id is passed in request it will 
	 * do update operation, if record found for 
	 * the student id.
	 * 
	 * @param request
	 * @return EnrolmentResponse
	 * @throws APMException
	 */
	public EnrolmentResponse processEnrolment(@Valid EnrolmentRequest request) throws APMException{

		logger.log(Level.INFO, "process enrolment validate start");

		validateRequest(request);

		logger.log(Level.INFO, "process enrolment validate end");

		return putEnrolment(request);
	}

	/**
	 * This request validates below two validation:
	 * 1.> Age of student must be in between 16 to 50
	 * 2.> Course in request must be a valid course
	 * 
	 * @param request
	 * @throws APMException 
	 */
	private void validateRequest(@Valid EnrolmentRequest request) throws APMException {

		logger.log(Level.INFO, "validating request");

		if(Integer.parseInt(request.getStudentAge()) <= 16 || Integer.parseInt(request.getStudentAge()) >= 50) 
			throw new APMException(CommonConstants.APM_001, APMErrorConfig.string(CommonConstants.APM_001));

		if(!isCourseValid(request.getCourse()))
			throw new APMException(CommonConstants.APM_002, APMErrorConfig.string(CommonConstants.APM_002));

		logger.log(Level.INFO, "request validated");

	}

	/**
	 * This method checks the course is valid or not.
	 * 
	 * @param CourseCode
	 * @return boolean
	 * @throws APMException
	 */
	private boolean isCourseValid(String courseName) throws APMException {

		logger.log(Level.INFO, "validating course");

		Course course = null;
		try {
			course = apmDBService.getCourseFromCourseName(courseName);
		} catch (NoSuchElementException e) {
			return false;
		}
		return (null != course);
	}


	/**
	 * This method creates a new record in Enrolment and student table,
	 * if student id is passed in request it will update existing
	 * record, if found.
	 * 
	 * @param request 
	 * @return 
	 * @throws APMException 
	 * 
	 */
	private EnrolmentResponse putEnrolment(EnrolmentRequest request) throws APMException {

		logger.log(Level.INFO, "put enrolment start");

		Student student = null;
		Enrolment enrolment = null;

		Course course = apmDBService.getCourseFromCourseName(request.getCourse());

		if(null != request.getStudentId() && !"".equals(request.getStudentId().trim())) {
			student = apmDBService.getStudentFromStudentId(request.getStudentId());
			if(null == student)
				throw new APMException(CommonConstants.APM_004, APMErrorConfig.string(CommonConstants.APM_004));

			enrolment = apmDBService.getEnrolmentFromStudentId(request.getStudentId());
			if(null == enrolment)
				throw new APMException(CommonConstants.APM_003, APMErrorConfig.string(CommonConstants.APM_003));
		}

		if(null == enrolment) {
			enrolment = new Enrolment();
			enrolment.setEnrolmentId(CommonUtil.generateEnrolmentId());
		}	
		enrolment.setCourseCode(course.getCourseCode());

		if(null == student) {
			student = new Student();
			student.setStudentId(CommonUtil.genrateStudentId());
		}	
		student.setStudentAge(request.getStudentAge());
		student.setStudentName(request.getStudentName());

		enrolment.setStudentId(student.getStudentId());

		apmDBService.saveEnrolment(enrolment);
		apmDBService.saveStudent(student);

		EnrolmentResponse response = new EnrolmentResponse();
		response.setEnrolmentId(enrolment.getEnrolmentId());
		response.setStudentId(student.getStudentId());

		logger.log(Level.INFO, "enrolment saved successfully");

		return response;
	}

	/**
	 * Fetches student with course details on the basis of student id.
	 * 
	 * @param studentId
	 * @return StudentResponse
	 * @throws APMException
	 */
	public StudentResponse getStudentDetails(String studentId) throws APMException {

		Enrolment enrolment = apmDBService.getEnrolmentFromStudentId(studentId);
		if(null == enrolment)
			throw new APMException(CommonConstants.APM_003, APMErrorConfig.string(CommonConstants.APM_003));

		Student student = apmDBService.getStudentFromStudentId(studentId);
		if(null == student)
			throw new APMException(CommonConstants.APM_004, APMErrorConfig.string(CommonConstants.APM_004));

		Course course = apmDBService.getCourseFromCourseId(enrolment.getCourseCode());
		if(null == course)
			throw new APMException(CommonConstants.APM_005, APMErrorConfig.string(CommonConstants.APM_005));

		StudentResponse response = new StudentResponse();
		response.setStudentId(studentId);
		response.setStudentName(student.getStudentName());
		response.setStudentAge(student.getStudentAge());
		response.setCourseEnroled(course.getCourseName());

		return response;
	}

	/**
	 * Deletes student and enroled course details from system.
	 * @param studentId
	 * @throws APMException 
	 */
	public void deleteStudent(String studentId) throws APMException {

		Enrolment enrolment = apmDBService.getEnrolmentFromStudentId(studentId);
		if(null == enrolment)
			throw new APMException(CommonConstants.APM_003, APMErrorConfig.string(CommonConstants.APM_003));

		Student student = apmDBService.getStudentFromStudentId(studentId);
		if(null == student)
			throw new APMException(CommonConstants.APM_004, APMErrorConfig.string(CommonConstants.APM_004));

		apmDBService.deleteStudent(studentId);
	}
}
