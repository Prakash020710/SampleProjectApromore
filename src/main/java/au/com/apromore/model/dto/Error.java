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
package au.com.apromore.model.dto;

/**
 * @author : Prakash Karki
 * @Purpose : Error | Error response class
 * @Created : 26 Feb 2024 10:12:19 pm
 */
public class Error {

	private String errorId;
	
	private String errorMessage;

	/**
	 * @return the errorId
	 */
	public String getErrorId() {
		return errorId;
	}

	/**
	 * @param errorId the errorId to set
	 */
	public void setErrorId(String errorId) {
		this.errorId = errorId;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
