package com.api.arbolb.apirestarbolb.utilidades.beans.excepciones;

public class ErrorTransaccionArchivoDiscoRuntimeException extends RuntimeException {

	private static final long serialVersionUID = -8189618277103360429L;

	public ErrorTransaccionArchivoDiscoRuntimeException() {
		super();
	}

	public ErrorTransaccionArchivoDiscoRuntimeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ErrorTransaccionArchivoDiscoRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public ErrorTransaccionArchivoDiscoRuntimeException(String message) {
		super(message);
	}

	public ErrorTransaccionArchivoDiscoRuntimeException(Throwable cause) {
		super(cause);
	}

}
