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

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.apromore.model.entity.Student;


/**
 * @author : Prakash Karki
 * @Purpose : StudentRepository | Repository for Student entity
 * @Created : 25 Feb 2024 10:24:05 pm
 */
public interface StudentRepository extends JpaRepository<Student, String> {
}
