package com.narendra.covid.utilities.covidutilities.exception;

public class ServiceException extends CovidUtilsException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8169365216752551938L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

	
}
