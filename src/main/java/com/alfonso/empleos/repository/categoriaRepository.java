package com.alfonso.empleos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alfonso.empleos.model.Categoria;

@Repository
public interface categoriaRepository extends JpaRepository<Categoria, Long> {

	
}
