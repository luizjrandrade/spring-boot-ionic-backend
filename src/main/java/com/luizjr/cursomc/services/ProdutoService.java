package com.luizjr.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luizjr.cursomc.domain.Cliente;
import com.luizjr.cursomc.domain.Produto;
import com.luizjr.cursomc.repositories.ClienteRepository;
import com.luizjr.cursomc.repositories.ProdutoRepository;
import com.luizjr.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repo;
	
	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}
}
