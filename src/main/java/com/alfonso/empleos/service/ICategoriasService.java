package com.alfonso.empleos.service;

import java.util.List;

import com.alfonso.empleos.model.Categoria;

public interface ICategoriasService {
	void guardar(Categoria categoria);
	List<Categoria> buscarTodas();
	Categoria buscarPorId(Long id);
}
