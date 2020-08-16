package com.narendra.covid.utilities.covidutilities.exception;

public class ResourceNotFound extends ServiceException {

	private static final long serialVersionUID = 7419500947837756181L;

	public ResourceNotFound() {
		super();
	}

	public ResourceNotFound(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public ResourceNotFound(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ResourceNotFound(String arg0) {
		super(arg0);
	}

	public ResourceNotFound(Throwable arg0) {
		super(arg0);
	}
	
	

}
