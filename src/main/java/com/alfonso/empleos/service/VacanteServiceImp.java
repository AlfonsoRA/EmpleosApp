package com.alfonso.empleos.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alfonso.empleos.model.Vacante;
import com.alfonso.empleos.repository.vacanteRepository;

@Service
public class VacanteServiceImp implements IVacantesService{

	@Autowired
	vacanteRepository repoVacante;
	
	@Override
	public List<Vacante> buscarTodas() {
		return (List<Vacante>) repoVacante.findAll();
	}

	@Override
	public Vacante buscarPorId(Long id) {
		return repoVacante.findById(id).orElse(null);
	}

	@Override
	public void guardar(Vacante vacante) {
		repoVacante.save(vacante);		
	}

	@Override
	public List<Vacante> buscarXDestacado(String estatus, int destacado) {
		return repoVacante.findByEstatusAndDestacadoOrderByIdDesc(estatus, destacado).orElse(null);
	}

}
