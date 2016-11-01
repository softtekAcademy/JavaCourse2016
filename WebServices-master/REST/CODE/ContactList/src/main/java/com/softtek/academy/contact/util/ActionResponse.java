package com.softtek.academy.contact.util;

import org.springframework.http.HttpStatus;

/**
 * Class related to a request response, it determines if operation was success or not.
 * 
 * @author David.Hernandez
 */
public class ActionResponse {
	
	// ------- Instance members ------- //
	
	// Additional message to send.
	private String message;
	
	// Additional data to send (optional).
	private Object xdata;
	
	// By default all operations are successful.
	private boolean isSuccess = true;
	
	// By default all operations are successful.
	private HttpStatus statusCode;
	
	/**
	 * 'ActionResponse' default constructor.
	 */
	public ActionResponse(){}
	
	/**
	 * 'ActionResponse' overloaded constructor.
	 * 
	 * @param (String) message - Message to display in case of error.
	 * @param (Object) additionalData - Possible additional data to send in response.
	 * @param (boolean) isSuccess - Boolean variable that determine is success or not.
	 */
	public ActionResponse(final String message, final Object additionalData, final boolean isSuccess, 
			final HttpStatus statusCode){
		
		this.message = message;
		this.xdata = additionalData;
		this.isSuccess = isSuccess;
		this.statusCode = statusCode;
	}
	
	// ------- Getters & Setters ------- //
	
	/**
	 * @return the message
	 */
	public String getMessage() {
	
		return message;
	}
	
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
	
		this.message = message;
	}
	
	
	/**
	 * @return the isSuccess
	 */
	public boolean isSuccess() {
	
		return isSuccess;
	}
	
	/**
	 * @param isSuccess the isSuccess to set
	 */
	public void setSuccess(boolean isSuccess) {
	
		this.isSuccess = isSuccess;
	}

	
	/**
	 * @return the xdata
	 */
	public Object getXdata() {
	
		return xdata;
	}

	
	/**
	 * @param xdata the xdata to set
	 */
	public void setXdata(Object xdata) {
	
		this.xdata = xdata;
	}

	
	/**
	 * @return the statusCode
	 */
	public HttpStatus getStatusCode() {
	
		return statusCode;
	}

	
	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(HttpStatus statusCode) {
	
		this.statusCode = statusCode;
	}

}
