package com.api.arbolb.apirestarbolb.utilidades.beans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ControllerAdviceResponse implements Serializable {

	private static final long serialVersionUID = 9121521826726895378L;

	@JsonProperty("httpStatus")
	String estadoHttp;
	
	@JsonProperty("errorMessage")
	String mensajeError;

}
