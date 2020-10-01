package com.alfonso.empleos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alfonso.empleos.model.Vacante;

@Repository
public interface vacanteRepository extends CrudRepository<Vacante, Long> {
	
	Optional <List<Vacante>> findByEstatus(String estatus);
	
	Optional<List<Vacante>> findByEstatusAndDestacadoOrderByIdDesc(String estatus, int destacado);
	
	Optional<List<Vacante>> findBySalarioBetweenOrderBySalarioDesc(int salario1, int salario2);
	
	Optional<List<Vacante>> findByDestacado(int destacado);
	
	//select * from Vacante where estatus in ('Aprobada','eliminada')
	Optional<List<Vacante>> findByEstatusIn(String[] estatus);
}
