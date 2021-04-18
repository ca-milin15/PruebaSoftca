package com.api.arbolb.apirestarbolb.arbolDB.beans;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@Component
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Arbol implements Serializable{
	
	private static final long serialVersionUID = -2999338597437003668L;
	
	Nodo nodo;
	int autoincremental = 1;
	
	public Arbol obtenerArbol (ObjectMapper objectMapper) {
		var rutaArchivo = Paths.get(
				"C:\\Users\\camilo\\Documents\\Proyectos Software\\PruebaSoftCaBack\\src\\main\\resources\\arbolDB\\tbl_usuario.json");
		var data = new StringBuilder();
		try (var reader = Files.newBufferedReader(rutaArchivo, Charset.forName("UTF-8"))) {
			var linea = new String();
			while ((linea = reader.readLine()) != null) {
				data.append(linea);
			}
			if (!ObjectUtils.isEmpty(data)) {
				return objectMapper.readValue(data.toString(), Arbol.class);
			}
			return new Arbol();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
