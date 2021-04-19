package com.api.arbolb.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.api.arbolb.apirestarbolb.utilidades.beans.ControllerAdviceResponse;
import com.api.arbolb.apirestarbolb.utilidades.beans.excepciones.ErrorConvirtiendoObjetoRuntimeException;
import com.api.arbolb.apirestarbolb.utilidades.beans.excepciones.ErrorTransaccionArchivoDiscoRuntimeException;
import com.api.arbolb.apirestarbolb.utilidades.beans.excepciones.ObjetoNoEncontradoException;
import com.api.arbolb.apirestarbolb.utilidades.beans.excepciones.ObjetoNoEncontradoRuntimeException;

@Configuration
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

	ControllerAdviceResponse controllerAdviceResponse;

	@ExceptionHandler(ErrorTransaccionArchivoDiscoRuntimeException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public String excepcionTransaccionArchivoEnDisco(
			ErrorTransaccionArchivoDiscoRuntimeException errorTransaccionArchivoDiscoRuntimeException,
			WebRequest request) {
		return errorTransaccionArchivoDiscoRuntimeException.getMessage();
	}

	@ExceptionHandler(Throwable.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public String excepcionGenerica(Throwable throwable, WebRequest request) {
		return throwable.getMessage();
	}

	@ExceptionHandler(ObjetoNoEncontradoRuntimeException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public String objetoNoEncontradoRuntimeExcepcion(
			ObjetoNoEncontradoRuntimeException objetoNoEncontradoRuntimeException, WebRequest request) {
		return objetoNoEncontradoRuntimeException.getMessage();
	}

	@ExceptionHandler(value = { ObjetoNoEncontradoRuntimeException.class })
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public String objetoNoEncontradoExcepcion(ObjetoNoEncontradoException objetoNoEncontradoException) {
		return objetoNoEncontradoException.getMessage();
	}

	@ResponseBody
	@ResponseStatus(value = HttpStatus.CONFLICT)
	@ExceptionHandler(value = { ErrorConvirtiendoObjetoRuntimeException.class })
	public String errorConvirtiendoObjetoRuntimeException(
			ErrorConvirtiendoObjetoRuntimeException errorConvirtiendoObjetoRuntimeException) {
		return errorConvirtiendoObjetoRuntimeException.getMessage();
	}

}
