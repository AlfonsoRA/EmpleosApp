package com.alfonso.empleos.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alfonso.empleos.model.Vacante;
import com.alfonso.empleos.service.ICategoriasService;
import com.alfonso.empleos.service.IVacantesService;
import com.alfonso.empleos.util.Utileria;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {

	@Autowired
	IVacantesService serviceVacantes;
	
	@Autowired
	@Qualifier("categoriaServiceImp")
	ICategoriasService serviceCategorias;
	
	//Inyecta el valor de application.properties
	@Value("${empleaosApp.ruta.imagenes}")
	private String ruta;
	

	@RequestMapping("/create")
	public String crearVacante(Vacante vacante, Model modelo) {
		modelo.addAttribute("categorias", serviceCategorias.buscarTodas());
		return "vacantes/formVacante";
	}

	@RequestMapping("/detalle/{id}")
	public String verDetalle(@PathVariable("id") Long idVacante, Model modelo) {
		Vacante vacante = serviceVacantes.buscarPorId(idVacante);
		System.out.println("Id De La Vacante " + vacante);
		modelo.addAttribute("vacante", vacante);
		return "vacantes/detalle";
	}

	@RequestMapping("/delete")
	public String eliminar(@RequestParam("id") int idVacante, Model modelo) {
		System.out.println("Vacante eliminada con el id " + idVacante);
		modelo.addAttribute("idVacante", idVacante);
		return "vacante";
	}

//	@PostMapping("/save")
//		public String guardar(@RequestParam("nombre")String nombre, @RequestParam("descripcion")String descripcion,
//			@RequestParam("estatus")String estatus, @RequestParam("fecha")String fecha, @RequestParam("destacado")int destacado,
//			@RequestParam("salario")double salario, @RequestParam("detalles")String detalles) {
//		System.out.println("nombre: "+nombre);
//		System.out.println("descripcion: "+descripcion);
//		System.out.println("estatus: "+estatus);
//		System.out.println("fecha: "+fecha);
//		System.out.println("destacado: "+destacado);
//		System.out.println("salario: "+salario);
//		System.out.println("detalles: "+detalles);
//		return "vacantes/listVacantes";
//		}
	
	@PostMapping("/save")
	public String guardar(Vacante vacante, BindingResult result, RedirectAttributes redirect, @RequestParam("archivoImagen") MultipartFile multiPart) {
		
		if (!multiPart.isEmpty()) {
			//String ruta = "/empleos/img-vacantes/"; // Linux/MAC
			//String ruta = "c:/empleos/img-vacantes/"; // Windows
			String nombreImagen = Utileria.guardarImagen(multiPart, ruta);
			if (nombreImagen != null){ // La imagen si se subio
				// Procesamos la variable nombreImagen
				vacante.setImagen(nombreImagen);
			}
		}
		
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println("Ocurrió un error: "+ error.getDefaultMessage());
				return"vacantes/formVacante";
			}
		}
		serviceVacantes.guardar(vacante);
		redirect.addFlashAttribute("msg", "Registro guardado.");
		System.out.println("Vacantes: "+vacante);
	return "redirect:/vacantes/index";
	}
	
	@RequestMapping("/index")
	public String mostrarIndex(Model modelo) {
		List<Vacante> vacante= serviceVacantes.buscarTodas();
		modelo.addAttribute("vacantes", vacante);
		return"vacantes/listVacante";
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
		
}
