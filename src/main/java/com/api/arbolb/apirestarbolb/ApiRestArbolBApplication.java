package com.api.arbolb.apirestarbolb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.api.arbolb.configuration.propiedades.Propiedades;

@SpringBootApplication
@EnableConfigurationProperties(Propiedades.class)
public class ApiRestArbolBApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestArbolBApplication.class, args);
	}

}
