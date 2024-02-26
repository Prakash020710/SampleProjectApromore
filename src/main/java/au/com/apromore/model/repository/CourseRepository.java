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
package au.com.apromore.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.apromore.model.entity.Course;

/**
 * @author : Prakash Karki
 * @Purpose : CourseRepository | Repository for Course entity
 * @Created : 25 Feb 2024 10:24:46 pm
 */
public interface CourseRepository extends JpaRepository<Course, String> {

	Optional<Course> findByCourseName(String courseName);
}
