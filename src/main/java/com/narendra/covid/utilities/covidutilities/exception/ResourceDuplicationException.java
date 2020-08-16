package com.narendra.covid.utilities.covidutilities.exception;

public class ResourceDuplicationException extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7332001268564868939L;

	public ResourceDuplicationException() {
		super();
	}

	public ResourceDuplicationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ResourceDuplicationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ResourceDuplicationException(String message) {
		super(message);
	}

	public ResourceDuplicationException(Throwable cause) {
		super(cause);
	}

	
}
