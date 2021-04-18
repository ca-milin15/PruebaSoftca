package com.api.arbolb.apirestarbolb.usuario.repository;

import com.api.arbolb.apirestarbolb.usuario.bean.Usuario;

public interface UsuarioRepository {

	Usuario buscarUsuarioPorId(Integer idUsuario);
	
	Usuario crearUsuario(Usuario usuario);
	
}
