package com.api.arbolb.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.api.arbolb.apirestarbolb.utilidades.Utilidades;
import com.api.arbolb.apirestarbolb.utilidades.beans.ControllerAdviceResponse;
import com.api.arbolb.apirestarbolb.utilidades.beans.excepciones.ErrorConvirtiendoObjetoRuntimeException;
import com.api.arbolb.apirestarbolb.utilidades.beans.excepciones.ErrorTransaccionArchivoDiscoRuntimeException;
import com.api.arbolb.apirestarbolb.utilidades.beans.excepciones.ObjetoNoEncontradoException;
import com.api.arbolb.apirestarbolb.utilidades.beans.excepciones.ObjetoNoEncontradoRuntimeException;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {

	ControllerAdviceResponse controllerAdviceResponse;

	@ExceptionHandler(ObjetoNoEncontradoRuntimeException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ControllerAdviceResponse objetoNoEncontradoRuntimeExcepcion(
			ObjetoNoEncontradoRuntimeException objetoNoEncontradoRuntimeException) {

		return Utilidades.generarObjetoRespuesta(HttpStatus.NOT_FOUND, objetoNoEncontradoRuntimeException,
				objetoNoEncontradoRuntimeException.getMessage(), true);

	}

	@ExceptionHandler(Throwable.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ControllerAdviceResponse excepcionGenerica(Throwable throwable) {
		return Utilidades.generarObjetoRespuesta(HttpStatus.NOT_FOUND, throwable, throwable.getMessage(), true);
	}

	@ExceptionHandler(ErrorTransaccionArchivoDiscoRuntimeException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ControllerAdviceResponse excepcionTransaccionArchivoEnDisco(
			ErrorTransaccionArchivoDiscoRuntimeException errorTransaccionArchivoDiscoRuntimeException) {
		return Utilidades.generarObjetoRespuesta(HttpStatus.NOT_FOUND, errorTransaccionArchivoDiscoRuntimeException,
				errorTransaccionArchivoDiscoRuntimeException.getMessage(), true);
	}

	@ExceptionHandler(value = { ObjetoNoEncontradoRuntimeException.class })
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public ControllerAdviceResponse objetoNoEncontradoExcepcion(
			ObjetoNoEncontradoException errorConvirtiendoObjetoRuntimeException) {
		return Utilidades.generarObjetoRespuesta(HttpStatus.NOT_FOUND, errorConvirtiendoObjetoRuntimeException,
				errorConvirtiendoObjetoRuntimeException.getMessage(), true);
	}

	@ResponseBody
	@ResponseStatus(value = HttpStatus.CONFLICT)
	@ExceptionHandler(value = { ErrorConvirtiendoObjetoRuntimeException.class })
	public ControllerAdviceResponse errorConvirtiendoObjetoRuntimeException(
			ErrorConvirtiendoObjetoRuntimeException errorConvirtiendoObjetoRuntimeException) {
		return Utilidades.generarObjetoRespuesta(HttpStatus.NOT_FOUND, errorConvirtiendoObjetoRuntimeException,
				errorConvirtiendoObjetoRuntimeException.getMessage(), true);
	}

}
