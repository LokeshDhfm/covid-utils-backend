package com.narendra.covid.utilities.covidutilities.service;

import com.narendra.covid.utilities.covidutilities.exception.ServiceException;

public class PriceException extends ServiceException {

	private static final long serialVersionUID = 8167991686699511467L;

	public PriceException() {
		super();
	}

	public PriceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PriceException(String message, Throwable cause) {
		super(message, cause);
	}

	public PriceException(String message) {
		super(message);
	}

	public PriceException(Throwable cause) {
		super(cause);
	}

}
