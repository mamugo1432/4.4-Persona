package com.model.Excepciones;

public class InvalidNumberException extends Exception {
private static final String MENSAJE="El número introducido no es válido";
	public InvalidNumberException() {
		super(MENSAJE);
	}

	public InvalidNumberException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidNumberException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidNumberException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidNumberException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
