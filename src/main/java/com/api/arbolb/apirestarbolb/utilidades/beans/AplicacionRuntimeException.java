package com.api.arbolb.apirestarbolb.utilidades.beans;

public class AplicacionRuntimeException extends RuntimeException{


	private static final long serialVersionUID = 9032376779048943066L;

	public AplicacionRuntimeException() {
		super();
	}

	public AplicacionRuntimeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AplicacionRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public AplicacionRuntimeException(String message) {
		super(message);
	}

	public AplicacionRuntimeException(Throwable cause) {
		super(cause);
	}

	
}
