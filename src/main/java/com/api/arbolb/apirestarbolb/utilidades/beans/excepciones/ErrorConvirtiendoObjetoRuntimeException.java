package com.api.arbolb.apirestarbolb.utilidades.beans.excepciones;

public class ErrorConvirtiendoObjetoRuntimeException extends RuntimeException {

	private static final long serialVersionUID = -2384516121825933097L;

	public ErrorConvirtiendoObjetoRuntimeException() {
		super();
	}

	public ErrorConvirtiendoObjetoRuntimeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ErrorConvirtiendoObjetoRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public ErrorConvirtiendoObjetoRuntimeException(String message) {
		super(message);
	}

	public ErrorConvirtiendoObjetoRuntimeException(Throwable cause) {
		super(cause);
	}

}
