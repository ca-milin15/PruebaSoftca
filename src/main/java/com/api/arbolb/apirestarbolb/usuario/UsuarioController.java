package com.api.arbolb.apirestarbolb.usuario;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.arbolb.apirestarbolb.usuario.bean.UsuarioRequest;
import com.api.arbolb.apirestarbolb.usuario.bean.UsuarioResponse;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("usuario")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class UsuarioController {

	UsuarioService usuarioService;

	@GetMapping("{idUsuario}")
	public ResponseEntity<UsuarioResponse> buscarUsuarioPorId(@PathVariable(name = "idUsuario") Integer idUsuario) {
		return new ResponseEntity<>(usuarioService.buscarUsuarioPorId(idUsuario), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<UsuarioResponse> crearUsuario(@RequestBody UsuarioRequest usuarioRequest) {
		return new ResponseEntity<>(usuarioService.crearUsuario(usuarioRequest), HttpStatus.OK);
	}

	@PutMapping("{idUsuario}")
	public ResponseEntity<UsuarioResponse> actualizarUsuario(@PathVariable(name = "idUsuario") Integer idUsuario,
			@RequestBody UsuarioRequest usuarioRequest) {
		return new ResponseEntity<>(usuarioService.actualizarUsuario(idUsuario, usuarioRequest), HttpStatus.OK);
	}
}
