package com.api.arbolb.apirestarbolb.usuario.repository;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.api.arbolb.apirestarbolb.arbolDB.ArbolDBService;
import com.api.arbolb.apirestarbolb.usuario.bean.Usuario;
import com.api.arbolb.apirestarbolb.utilidades.beans.excepciones.ErrorConvirtiendoObjetoRuntimeException;
import com.api.arbolb.apirestarbolb.utilidades.beans.excepciones.ObjetoNoEncontradoException;
import com.api.arbolb.apirestarbolb.utilidades.beans.excepciones.ObjetoNoEncontradoRuntimeException;
import com.api.arbolb.configuration.propiedades.Propiedades;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioRepositoryImpl implements UsuarioRepository {

	ObjectMapper objectMapper;
	Propiedades propiedades;
	ArbolDBService arbolDBService;

	@Override
	public Usuario buscarUsuarioPorId(Integer idUsuario) {
		try {
			var entidadComoString = arbolDBService.buscarObjeto(idUsuario);
			var usuario = objectMapper.readValue((String) entidadComoString, Usuario.class);
			usuario.setId(idUsuario);
			return usuario;
		} catch (JsonProcessingException jsonMappingException) {
			throw new ErrorConvirtiendoObjetoRuntimeException(propiedades.getMensajes().getErrorConvirtiendoObjeto());
		} catch (ObjetoNoEncontradoException objetoNoEncontradoExcepcion) {
			throw new ObjetoNoEncontradoRuntimeException(
					String.format(objetoNoEncontradoExcepcion.getMessage(), idUsuario));
		}
	}

	@Override
	public Usuario crearUsuario(Usuario usuario) {
		return (Usuario) arbolDBService.almacenarObjeto(usuario, Usuario.class);
	}

	@Override
	public Usuario actualizarUsuario(Integer id, Usuario usuario) {
		try {
			var usuarioAlmacenado = buscarUsuarioPorId(id);
			BeanUtils.copyProperties(usuario, usuarioAlmacenado);
			var registroActualizado = arbolDBService.actualizarObjeto(id, usuario, Usuario.class);
			var usuarioActualizado = objectMapper.readValue((String) registroActualizado, Usuario.class);
			usuarioActualizado.setId(id);
			return usuarioActualizado;
		} catch (JsonProcessingException e) {
			throw new ErrorConvirtiendoObjetoRuntimeException(propiedades.getMensajes().getErrorConvirtiendoObjeto());
		}
	}

}
