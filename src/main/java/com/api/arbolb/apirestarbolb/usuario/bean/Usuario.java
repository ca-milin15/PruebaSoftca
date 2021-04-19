package com.api.arbolb.apirestarbolb.usuario.bean;

import java.io.Serializable;

import com.api.arbolb.apirestarbolb.utilidades.enums.beans.UsuarioEstadoEnum;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Serializable {

	private static final long serialVersionUID = -1238141218585369338L;

	Integer id;
	String nombreUsuario;
	String codigoUsuario;
	String nombreCompletoPersona;
	UsuarioEstadoEnum estado;

	public Usuario(UsuarioRequest usuarioRequest) {
		this.nombreUsuario = usuarioRequest.getNombreUsuario();
		this.codigoUsuario = usuarioRequest.getCodigoUsuario();
		this.nombreCompletoPersona = usuarioRequest.getNombreCompletoPersona();
		this.estado = UsuarioEstadoEnum.ACTIVO;
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
