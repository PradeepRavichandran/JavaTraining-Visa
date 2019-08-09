package com.visa.prj.dao;

public class PersistenceException extends Exception {

	public PersistenceException() {
	}

	public PersistenceException(String arg0) {
		super(arg0);
	}

	public PersistenceException(Throwable cause) {
		super(cause);
	}

	public PersistenceException(String message, Throwable cause) {
		super(message, cause);
	}

	public PersistenceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
