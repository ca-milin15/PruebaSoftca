package com.api.arbolb.configuration.propiedades;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
@ConfigurationProperties(prefix="propiedades")
public class Propiedades {

	Mensajes mensajes;
	
	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Mensajes {
		String entidadNoEncontrada;
		String errorLeyendoArchivoEnDisco;
		String errorConvirtiendoObjeto;
	}
}
