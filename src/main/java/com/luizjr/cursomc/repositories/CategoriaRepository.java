package com.luizjr.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luizjr.cursomc.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
