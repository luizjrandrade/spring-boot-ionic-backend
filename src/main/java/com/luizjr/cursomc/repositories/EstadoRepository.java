package com.luizjr.cursomc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luizjr.cursomc.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
	
	//retorna os estados ordenados por nome
	@Transactional(readOnly=true)
	public List<Estado> findAllByOrderByNome();

}
