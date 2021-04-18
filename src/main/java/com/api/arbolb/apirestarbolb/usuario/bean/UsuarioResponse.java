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
public class UsuarioResponse implements Serializable{
	
	private static final long serialVersionUID = 8958139939861176373L;
	
	Integer id;
	String nombreUsuario;
	String codigoUsuario;
	String nombreCompletoPersona;
	String estado;

	public UsuarioResponse(Usuario usuario) {
		this.id = usuario.getId();
		this.nombreUsuario = usuario.getNombreUsuario();
		this.codigoUsuario = usuario.getCodigoUsuario();
		this.nombreCompletoPersona = usuario.getNombreCompletoPersona();
		this.estado = usuario.getEstado();
	}
}
