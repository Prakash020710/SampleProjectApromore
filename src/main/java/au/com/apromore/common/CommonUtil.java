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
package au.com.apromore.common;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author : Prakash Karki
 * @Purpose : CommonUtil | Utility class.
 * @Created : 26 Feb 2024 8:12:35 pm
 */
public class CommonUtil {

	public static String generateEnrolmentId() {

		return CommonConstants.ENROLMENT_ID_PREFIX + 
				LocalDateTime.now(ZoneId.of(ZoneId.SHORT_IDS.get("AET"))).
				format(DateTimeFormatter.ofPattern(CommonConstants.DT_FORMAT_ID_GENERATION))
				+ (new SecureRandom().nextInt(90000) + 10000);
	}

	public static String genrateStudentId() {
		return CommonConstants.STUDENT_ID_PREFIX + 
				LocalDateTime.now(ZoneId.of(ZoneId.SHORT_IDS.get("AET"))).
				format(DateTimeFormatter.ofPattern(CommonConstants.DT_FORMAT_ID_GENERATION))
				+ (new SecureRandom().nextInt(90000) + 10000);
	}

}
