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

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.apromore.model.entity.Course;
import au.com.apromore.model.entity.Enrolment;
import au.com.apromore.model.entity.Student;
import au.com.apromore.model.repository.CourseRepository;
import au.com.apromore.model.repository.EnrolmentRepository;
import au.com.apromore.model.repository.StudentRepository;

/**
 * @author : Prakash Karki
 * @Purpose : APMDBService | Database transactions service.
 * @Created : 25 Feb 2024 10:27:09 pm
 */
@Service
public class APMDBService {

	@Autowired
	private EnrolmentRepository enrolmentRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Transactional
	public void saveEnrolment(Enrolment order) {

		enrolmentRepository.save(order);
		enrolmentRepository.flush();
	}

	@Transactional
	public Course getCourseFromCourseName(String courseName) {

		Optional<Course> courseOp = courseRepository.findByCourseName(courseName);
		return courseOp.isPresent() ?  courseOp.get() : null;
	}

	@Transactional
	public void saveStudent(Student student) {

		studentRepository.save(student);
		studentRepository.flush();
	}

	@Transactional
	public Enrolment getEnrolmentFromStudentId(String studentId) {

		Optional<Enrolment> enrolmentOp = enrolmentRepository.findByStudentId(studentId);
		return enrolmentOp.isPresent() ?  enrolmentOp.get() : null;
	}

	@Transactional
	public Student getStudentFromStudentId(String studentId) {

		Optional<Student> studentOp = studentRepository.findById(studentId);
		return studentOp.isPresent() ?  studentOp.get() : null;
	}

	@Transactional
	public Course getCourseFromCourseId(String courseCode) {

		Optional<Course> courseOp = courseRepository.findById(courseCode);
		return courseOp.isPresent() ?  courseOp.get() : null;
	}

	@Transactional
	public void deleteStudent(String studentId) {

		studentRepository.deleteById(studentId);
		Optional<Enrolment> enrolmentOP = enrolmentRepository.findByStudentId(studentId);
		enrolmentRepository.deleteById(enrolmentOP.get().getEnrolmentId());

	}
}
