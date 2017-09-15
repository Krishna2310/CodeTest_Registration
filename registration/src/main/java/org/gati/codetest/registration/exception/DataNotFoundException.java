package org.gati.codetest.registration.exception;

public class DataNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1809042446165156127L;
	
	public DataNotFoundException(String message){
		super(message);
	}
}
