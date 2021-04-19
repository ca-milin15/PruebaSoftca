package com.api.arbolb.apirestarbolb.usuario;

import com.api.arbolb.apirestarbolb.usuario.bean.UsuarioRequest;
import com.api.arbolb.apirestarbolb.usuario.bean.UsuarioResponse;

public interface UsuarioService {

	UsuarioResponse buscarUsuarioPorId(Integer idUsuario);
	
	UsuarioResponse crearUsuario(UsuarioRequest usuarioRequest);
	
	UsuarioResponse actualizarUsuario(Integer idUsuario, UsuarioRequest usuarioRequest);
}
