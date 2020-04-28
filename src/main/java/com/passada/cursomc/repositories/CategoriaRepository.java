package com.passada.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.passada.cursomc.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
