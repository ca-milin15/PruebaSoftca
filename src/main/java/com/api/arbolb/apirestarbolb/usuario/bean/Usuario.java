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
public class Usuario implements Serializable {

	private static final long serialVersionUID = -1238141218585369338L;

	Integer id;
	String nombreUsuario;
	String codigoUsuario;
	String nombreCompletoPersona;
	String estado;

	public Usuario(UsuarioRequest usuarioRequest) {
		this.nombreUsuario = usuarioRequest.getNombreUsuario();
		this.codigoUsuario = usuarioRequest.getCodigoUsuario();
		this.nombreCompletoPersona = usuarioRequest.getNombreCompletoPersona();
	}

	public Usuario(int indiceAsignadoAEntidad, Object objetoAAlmacenar) {
		var usuarioCasteado = (Usuario) objetoAAlmacenar;
		this.id = indiceAsignadoAEntidad;
		this.nombreUsuario = usuarioCasteado.getNombreUsuario();
		this.codigoUsuario = usuarioCasteado.getCodigoUsuario();
		this.nombreCompletoPersona = usuarioCasteado.getNombreCompletoPersona();
		this.estado = usuarioCasteado.getEstado();
	}
}
