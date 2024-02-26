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

import au.com.apromore.model.entity.Enrolment;

/**
 * @author : Prakash Karki
 * @Purpose : EnrolmentRepository | Repository for Enrolment entity
 * @Created : 25 Feb 2024 10:25:35 pm
 */
public interface EnrolmentRepository extends JpaRepository<Enrolment, String> {
	
	Optional<Enrolment> findByStudentId(String studentId);
}
