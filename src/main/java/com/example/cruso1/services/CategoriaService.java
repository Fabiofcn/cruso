package com.example.cruso1.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cruso1.Repositories.CategoriaRepository;
import com.example.cruso1.domain.Categoria;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository rep;
	
	public Categoria busca(Integer id) {
		Optional<Categoria> obj = rep.findById(id);
		return obj.orElse(null);
		
	}
}