package com.api.arbolb.apirestarbolb.utilidades.beans.excepciones;

import com.api.arbolb.apirestarbolb.utilidades.beans.AplicacionRuntimeException;

public class ObjetoNoEncontradoRuntimeException extends AplicacionRuntimeException {

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
