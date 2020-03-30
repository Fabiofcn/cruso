package com.example.cruso1.config;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.cruso1.Repositories.CategoriaRepository;
import com.example.cruso1.Repositories.ProdutoRepository;
import com.example.cruso1.domain.Categoria;
import com.example.cruso1.domain.Produto;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoria;
	@Autowired
	private ProdutoRepository produto;
	
	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(1, "Informática");
		 Categoria cat2 = new Categoria(2, "Escritório");
		
		 
		 
		 Produto p1 = new Produto(null, "nome", 222.00);
		 Produto p2 = new Produto(null, "2nome", 333.00);
		 Produto p3 = new Produto(null, "3nome", 444.00);
		 
		 cat1.getProduto().addAll(Arrays.asList(p1,p2,p3));
		 cat2.getProduto().addAll(Arrays.asList(p2));
		 
		 p1.getCategoria().addAll(Arrays.asList(cat1));
		 p2.getCategoria().addAll(Arrays.asList(cat1,cat2));
		 p3.getCategoria().addAll(Arrays.asList(cat1));
		 
		 categoria.saveAll(Arrays.asList(cat1,cat2));
		 produto.saveAll(Arrays.asList(p1,p2,p3));
	}

}
