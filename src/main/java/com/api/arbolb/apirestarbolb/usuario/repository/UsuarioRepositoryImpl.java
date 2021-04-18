package com.api.arbolb.apirestarbolb.usuario.repository;

import org.springframework.stereotype.Service;

import com.api.arbolb.apirestarbolb.arbolDB.ArbolDBService;
import com.api.arbolb.apirestarbolb.usuario.bean.Usuario;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioRepositoryImpl implements UsuarioRepository {

	ObjectMapper objectMapper;
	ArbolDBService arbolDBService;

	@Override
	public Usuario buscarUsuarioPorId(Integer idUsuario) {
		try {
			var entidadComoString = arbolDBService.buscarObjeto(idUsuario);
			var usuario = (Usuario) convertirObjeto(entidadComoString, Usuario.class);
			usuario.setId(idUsuario);
			return usuario;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private <T> Object convertirObjeto(String entidadComoString, Class<T> entidad) throws JsonMappingException, JsonProcessingException {
		return objectMapper.readValue(entidadComoString, entidad);
	}
	
	@Override
	public Usuario crearUsuario(Usuario usuario) {
		return (Usuario) arbolDBService.almacenarObjeto(usuario, Usuario.class);
	}

}
