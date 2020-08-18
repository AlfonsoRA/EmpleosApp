package com.alfonso.empleos.util;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class Utileria {

	public static String guardarImagen(MultipartFile multiPart, String ruta) {
		// se almacena el nombre original de la imagen en una variable
		String nombre= multiPart.getOriginalFilename();
		nombre= nombre.replace(" ", "_");
		
		String nombreFinal= randomAlphaNumeric(8) + nombre;
		try {
			// se crea un objeto file y se concatena la ruta y el nombre
			File fileImagen= new File(ruta + nombreFinal);
			// transfiere el file a la ruta temporal 
			multiPart.transferTo(fileImagen);
			System.out.println("Archivo: " + fileImagen.getAbsolutePath());
			// retornamos el nombre de la imagen
			return nombreFinal;
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
	}
	
	public static String randomAlphaNumeric(int count) {
		String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXY0123456789";
		StringBuilder builder = new StringBuilder();
		while(count-- != 0) {
			int character = (int)(Math.random()* CARACTERES.length());
			builder.append(CARACTERES.charAt(character));
		}
		return builder.toString();
	}
	
}
