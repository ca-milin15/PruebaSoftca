package com.api.arbolb.apirestarbolb.utilidades.beans.excepciones;

public class ObjetoNoEncontradoRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 342833154528261237L;

	public ObjetoNoEncontradoRuntimeException() {
		super();
	}

	public ObjetoNoEncontradoRuntimeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ObjetoNoEncontradoRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public ObjetoNoEncontradoRuntimeException(String message) {
		super(message);
	}

	public ObjetoNoEncontradoRuntimeException(Throwable cause) {
		super(cause);
	}

}
