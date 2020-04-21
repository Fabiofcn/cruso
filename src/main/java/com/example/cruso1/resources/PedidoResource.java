package com.example.cruso1.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.cruso1.domain.Pedido;
import com.example.cruso1.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {
	@Autowired
	private PedidoService ser; 
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pedido> find(@PathVariable Integer id) {
		
		Pedido cat1 =ser.find(id);

		return ResponseEntity.ok().body(cat1);
	}
	
}
