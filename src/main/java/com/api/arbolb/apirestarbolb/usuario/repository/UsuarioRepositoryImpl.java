package com.api.arbolb.apirestarbolb.usuario.repository;

import org.springframework.stereotype.Service;

import com.api.arbolb.apirestarbolb.arbolDB.ArbolDBService;
import com.api.arbolb.apirestarbolb.usuario.bean.Usuario;
import com.api.arbolb.apirestarbolb.utilidades.beans.excepciones.*;
import com.fasterxml.jackson.core.JsonProcessingException;
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
			var usuario = objectMapper.readValue((String) entidadComoString, Usuario.class);
			usuario.setId(idUsuario);
			return usuario;
		} catch (JsonProcessingException jsonMappingException) {
			throw new ErrorConvirtiendoObjetoRuntimeException("");
		} catch (ObjetoNoEncontradoException objetoNoEncontradoExcepcion) {
			throw new ObjetoNoEncontradoRuntimeException(
					String.format(objetoNoEncontradoExcepcion.getMessage(), idUsuario));
		}
	}

	@Override
	public Usuario crearUsuario(Usuario usuario) {
		return (Usuario) arbolDBService.almacenarObjeto(usuario, Usuario.class);
	}

}
