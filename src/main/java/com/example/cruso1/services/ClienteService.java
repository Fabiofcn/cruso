package com.example.cruso1.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cruso1.Repositories.ClienteRepository;
import com.example.cruso1.domain.Cliente;
import com.example.cruso1.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository rep;
		
	public Cliente find(Integer id) {
		Optional<Cliente> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
		
	}
	
}
