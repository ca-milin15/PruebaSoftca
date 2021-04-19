package com.api.arbolb.apirestarbolb.utilidades;

import org.springframework.http.HttpStatus;

import com.api.arbolb.apirestarbolb.utilidades.beans.ControllerAdviceResponse;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class Utilidades {

	public ControllerAdviceResponse generarObjetoRespuesta(HttpStatus status, Throwable e, String mensaje, boolean logs) {
		var controllerAdviceResponse = new ControllerAdviceResponse();
		controllerAdviceResponse.setMensajeError(mensaje);
		controllerAdviceResponse.setEstadoHttp(status.getReasonPhrase());
		if (logs) {
			log.error(e.getMessage());
		}
		return controllerAdviceResponse;
	}
}
