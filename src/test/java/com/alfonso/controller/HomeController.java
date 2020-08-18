package com.alfonso.controller;

import java.util.Date;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//Es una anotación de conveniencia que no hace más que agregar las anotaciones @Controller y @ResponseBody en una sola declaración
@RestController
public class HomeController {
	

	@GetMapping("/")
	public String iniciar() {
		return "Hola Mundo";
	}
	

}
