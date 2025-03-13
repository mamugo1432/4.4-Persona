package com.model.Excepciones;

public class InvalidPesoException extends Exception {
private static final String MENSAJE="El peso introducido no es válido";
	public InvalidPesoException() {
		super(MENSAJE);
	}

	public InvalidPesoException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidPesoException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidPesoException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidPesoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
