package com.api.arbolb.apirestarbolb.utilidades.beans;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ControllerAdviceResponse implements Serializable {

	private static final long serialVersionUID = 9121521826726895378L;

	String mensajeError;

}
