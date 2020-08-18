package com.alfonso.empleos.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.alfonso.empleos.model.Vacante;

@Service
public class VacanteServiceImp implements IVacantesService{

	private List<Vacante> lista = null;
	
	public VacanteServiceImp() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		lista = new LinkedList<>();
		try {
			Vacante vacante1 = new Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Ingeniero Civil");
			vacante1.setDescripcion("Se solicita Ing. Civil para diseñar un puente peatonal");
			vacante1.setFecha(sdf.parse("08-02-2019"));
			vacante1.setSalario(9600);
			vacante1.setDestacada(1);
			vacante1.setImagen("logo15.png");

			Vacante vacante2 = new Vacante();
			vacante2.setId(2);
			vacante2.setNombre("Contador Publico");
			vacante2.setDescripcion("Se solicita Contador Publico");
			vacante2.setFecha(sdf.parse("18-02-2019"));
			vacante2.setSalario(9800);
			vacante2.setDestacada(0);
			vacante2.setImagen("logo14.png");

			Vacante vacante3 = new Vacante();
			vacante3.setId(3);
			vacante3.setNombre("Ingeniero Electrico");
			vacante3.setDescripcion("Se solicita Ing. Electrico");
			vacante3.setFecha(sdf.parse("28-02-2019"));
			vacante3.setSalario(9900);
			vacante3.setDestacada(1);
			vacante3.setImagen("logo16.png");
			
			lista.add(vacante1);
			lista.add(vacante2);
			lista.add(vacante3);
		}catch (ParseException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<Vacante> buscarTodas() {
		return lista;
	}

	@Override
	public Vacante buscarPorId(Integer id) {
		for (Vacante vacante : lista) {
			if (vacante.getId() == id) {
				return vacante;
			}
		}
		return null;
	}

	@Override
	public void guardar(Vacante vacante) {
		lista.add(vacante);		
	}

}
