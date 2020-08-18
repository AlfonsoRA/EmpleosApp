package com.alfonso.empleos.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.alfonso.empleos.model.Categoria;

@Service
public class CategoriaServiceImp implements ICategoriasService {
	
	private List<Categoria> listaCateg= null;
	
	public CategoriaServiceImp() {
		super();
		listaCateg = new LinkedList<Categoria>();
		Categoria categoria1 = new Categoria();
		Categoria categoria2 = new Categoria();
		Categoria categoria3 = new Categoria();	
	}

	@Override
	public void guardar(Categoria categoria) {
		listaCateg.add(categoria);
		
	}

	@Override
	public List<Categoria> buscarTodas() {
		
		
		return listaCateg;
	}

	@Override
	public Categoria buscarPorId(Integer id) {
		for (Categoria categoria : listaCateg) {
			if (categoria.getId() == id) {
				return categoria;
			}
			
		}

		return null;
	}

}
