package com.cognizant.exception;

public class ApplicationException extends Exception {
	public ApplicationException(String message) {
		super(message);
	}

	public ApplicationException(Throwable throwable) {
		super(throwable);
	}

	public ApplicationException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
