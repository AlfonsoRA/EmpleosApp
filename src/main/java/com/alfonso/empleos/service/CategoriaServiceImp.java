package com.alfonso.empleos.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.alfonso.empleos.model.Categoria;
import com.alfonso.empleos.repository.categoriaRepository;

@Service
//Anotacion Primary sirve para dar prioridad a esta implementacion sobre la interface
//@Primary
public class CategoriaServiceImp implements ICategoriasService {
	
	@Autowired
	categoriaRepository repoCategorias;

	@Override
	public void guardar(Categoria categoria) {
		repoCategorias.save(categoria);		
	}

	@Override
	public List<Categoria> buscarTodas() {
		return repoCategorias.findAll();
	}

	@Override
	public Categoria buscarPorId(Long id) {
		return repoCategorias.findById(id).orElse(null);
	}

}
