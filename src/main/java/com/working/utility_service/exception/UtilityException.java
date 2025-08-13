package com.working.utility_service.exception;

public class UtilityException extends Exception{

	  /**
	 * 
	 */
	private static final long serialVersionUID = 5178380379640045622L;

	public UtilityException() {
	        super();
	    }

	    public UtilityException(String message) {
	        super(message);
	    }

	    public UtilityException(String message, Throwable cause) {
	        super(message, cause);
	    }

	    public UtilityException(Throwable cause) {
	        super(cause);
	    }
}
