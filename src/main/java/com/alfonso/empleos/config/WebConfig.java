package com.alfonso.empleos.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Value("${empleaosApp.ruta.imagenes}")
	private String rutaLogo;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registro) {
		registro.addResourceHandler("/logos/**").addResourceLocations("file:"+ rutaLogo);
	}
}
