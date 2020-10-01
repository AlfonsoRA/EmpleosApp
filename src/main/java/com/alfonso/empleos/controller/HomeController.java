package com.alfonso.empleos.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alfonso.empleos.model.Vacante;
import com.alfonso.empleos.service.IVacantesService;

@Controller
public class HomeController {
	
	@Autowired
	IVacantesService serviceVacantes;
	
	@GetMapping("/")
	public String mostrarHome(Model modelo) {		
	List<Vacante> vacantes = serviceVacantes.buscarXDestacado("Aprobada",1);
	modelo.addAttribute("vacantes", vacantes);
		return "home";
	}
	
	@GetMapping("/listado")
	public String mostrarListado(Model modelo) {
		List<String> lista = new LinkedList<String>();
		lista.add("Ingeniero en Informatica");
		lista.add("Auxiliar de Contabilidad");
		lista.add("Arquitecto");
		lista.add("Vendedor");
		modelo.addAttribute("empleos", lista);
		for (String vacante : lista) {
			System.out.println(vacante);
		}
		return "listado";
	}
	
	@GetMapping("/detalle")
	public String mostrarDetalle(Model modelo) {
		Vacante vacante= new Vacante();
		vacante.setNombre("Ingeniero de Comunicaciones");
		vacante.setDescripcion("Se solicita ingeniero para dar soporte a internet");
		vacante.setFecha(new Date());
		vacante.setSalario(9700);
		modelo.addAttribute("vacante", vacante);
		return "detalle";
	}
	
	@GetMapping("/tabla")
	public String mostrarTabla(Model modelo) {
		List<Vacante> listaVac = serviceVacantes.buscarTodas();
		modelo.addAttribute("vacantes", listaVac);
		return "tabla";
	}	
	
	@ModelAttribute
	public void vacanteGenerico(Model modelo) {
		modelo.addAttribute("vacante", serviceVacantes.buscarXDestacado("Aprobada", 1));
	}
	
}
