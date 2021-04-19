package com.api.arbolb.apirestarbolb.utilidades.enums.beans;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum UsuarioEstadoEnum {

	ACTIVO("ACT", "ACTIVO"),
	INACTIVO("INACT", "INACTIVO");
	
	String codigo;
	String descripcion;

	private UsuarioEstadoEnum(String codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}
	
	
}
