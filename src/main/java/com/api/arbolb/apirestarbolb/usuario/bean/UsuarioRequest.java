package com.api.arbolb.apirestarbolb.usuario.bean;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class UsuarioRequest implements Serializable{

	private static final long serialVersionUID = 3671871035341602662L;
	
	String nombreUsuario;
	String codigoUsuario;
	String nombreCompletoPersona;
}
