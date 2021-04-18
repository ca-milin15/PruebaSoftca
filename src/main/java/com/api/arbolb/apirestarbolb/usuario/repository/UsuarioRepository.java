package com.api.arbolb.apirestarbolb.usuario.repository;

import org.springframework.stereotype.Repository;

import com.api.arbolb.apirestarbolb.usuario.bean.Usuario;

@Repository
public interface UsuarioRepository {

	Usuario buscarUsuarioPorId(Integer idUsuario);
	
	Usuario crearUsuario(Usuario usuario);
	
}
