package com.api.arbolb.apirestarbolb.utilidades.beans.excepciones;

public class ObjetoNoEncontradoException extends Exception {

	private static final long serialVersionUID = -8425217438874180742L;

	public ObjetoNoEncontradoException() {
		super();
	}

	public ObjetoNoEncontradoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ObjetoNoEncontradoException(String message, Throwable cause) {
		super(message, cause);
	}

	public ObjetoNoEncontradoException(String message) {
		super(message);
	}

	public ObjetoNoEncontradoException(Throwable cause) {
		super(cause);
	}

}
