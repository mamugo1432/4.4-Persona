package com.model.Excepciones;

public class InvalidAlturaException extends Exception {
	private static final String MENSAJE="La altura introducido no es válido";
	public InvalidAlturaException() {
		super(MENSAJE);
	}

	public InvalidAlturaException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidAlturaException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidAlturaException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidAlturaException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
