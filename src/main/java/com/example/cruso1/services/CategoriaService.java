package com.example.cruso1.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cruso1.Repositories.CategoriaRepository;
import com.example.cruso1.domain.Categoria;
import com.example.cruso1.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository rep;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
		
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return rep.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return rep.save(obj);
	}
	
}
