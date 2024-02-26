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
package au.com.apromore.config;

import java.util.ResourceBundle;

/**
 * @author : Prakash Karki
 * @Purpose : APMErrorConfig | Error config class for error description.
 * @Created : 25 Feb 2024 10:38:33 pm
 */
public class APMErrorConfig {

	private static final String BUNDLE_NAME = "APM-error-config";
	
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
	
	public static String string(final String property) {
		
		return RESOURCE_BUNDLE.getString(property);
	}
}
