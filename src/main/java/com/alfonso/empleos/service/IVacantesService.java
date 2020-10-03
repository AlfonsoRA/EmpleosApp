package com.alfonso.empleos.service;

import java.util.List;

import com.alfonso.empleos.model.Vacante;

public interface IVacantesService {
	
	List<Vacante> buscarTodas();
	void guardar(Vacante vacante);
	public Vacante buscarPorId(Long id);
	List<Vacante> buscarXDestacado(String status, int destacado);
	void eliminar(Long idVacante);
}
