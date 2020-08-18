package com.alfonso.empleos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alfonso.empleos.model.Categoria;
import com.alfonso.empleos.service.ICategoriasService;

@Controller
@RequestMapping("/categorias")
public class CategoriasController {

	@Autowired
	ICategoriasService categoriaService;

	@RequestMapping("/index")
	public String mostrarIndex(Model modelo) {
		List<Categoria> categorias = categoriaService.buscarTodas();
		modelo.addAttribute("categorias", categorias);
		return "categorias/listCategorias";
	}

	@RequestMapping("/create")
	public String crear(Categoria categoria) {
		return "categorias/formCategorias";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String guardar(Categoria categoria, BindingResult binding, RedirectAttributes redirect) {
		if (binding.hasErrors()) {
			for (ObjectError error : binding.getAllErrors()) {
				System.out.println("Ocurrio un error: " + error.getDefaultMessage());
				return "categorias/formCategorias";
			}
		}
		categoriaService.guardar(categoria);
		redirect.addFlashAttribute("msg", "Registro guardado.");
		return "redirect:/categorias/index";
	}

}
