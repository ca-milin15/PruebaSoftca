package com.api.arbolb.apirestarbolb.usuario.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.api.arbolb.apirestarbolb.usuario.bean.Usuario;

@Service
@Qualifier("arbol")
public class UsuarioArbolBRepositoryImpl implements UsuarioRepository {

	@Override
	public Usuario buscarUsuarioPorId(Integer idUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario crearUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
