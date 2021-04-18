package com.api.arbolb.configuration;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ObjectUtils;

import com.api.arbolb.apirestarbolb.arbolDB.beans.Arbol;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@Configuration
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InitConfig {

	ObjectMapper objectMapper;
	Arbol arbol;

	@Bean
	public void init() {
		var rutaArchivo = Paths.get(
				"C:\\Users\\camilo\\Documents\\Proyectos Software\\PruebaSoftCaBack\\src\\main\\resources\\arbolDB\\tbl_usuario.json");
		var data = new StringBuilder();
		try (var reader = Files.newBufferedReader(rutaArchivo, Charset.forName("UTF-8"))) {
			var linea = new String();
			while ((linea = reader.readLine()) != null) {
				data.append(linea);
			}
			if (!ObjectUtils.isEmpty(data)) {
				this.arbol = objectMapper.readValue(data.toString(), Arbol.class);
			}
			System.out.println(this.arbol);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
