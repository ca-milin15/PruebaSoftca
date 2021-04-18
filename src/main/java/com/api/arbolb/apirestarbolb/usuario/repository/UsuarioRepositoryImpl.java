package com.api.arbolb.apirestarbolb.usuario.repository;

import org.springframework.stereotype.Service;

import com.api.arbolb.apirestarbolb.arbolDB.ArbolDBService;
import com.api.arbolb.apirestarbolb.usuario.bean.Usuario;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioRepositoryImpl implements UsuarioRepository {

	ArbolDBService arbolDBService;

	@Override
	public Usuario buscarUsuarioPorId(Integer idUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario crearUsuario(Usuario usuario) {
		return (Usuario) arbolDBService.almacenarObjeto(null, usuario, Usuario.class);
	}

}
