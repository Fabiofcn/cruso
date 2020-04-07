package com.example.cruso1.config;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.cruso1.Repositories.CategoriaRepository;
import com.example.cruso1.Repositories.CidadeRepository;
import com.example.cruso1.Repositories.ClienteRepository;
import com.example.cruso1.Repositories.EnderecoRepository;
import com.example.cruso1.Repositories.EstadoRepository;
import com.example.cruso1.Repositories.ItemPedidoRepository;
import com.example.cruso1.Repositories.PagamentoRepository;
import com.example.cruso1.Repositories.PedidoRepository;
import com.example.cruso1.Repositories.ProdutoRepository;
import com.example.cruso1.domain.Categoria;
import com.example.cruso1.domain.Cidade;
import com.example.cruso1.domain.Cliente;
import com.example.cruso1.domain.Endereco;
import com.example.cruso1.domain.Estado;
import com.example.cruso1.domain.ItemPedido;
import com.example.cruso1.domain.Pagamento;
import com.example.cruso1.domain.PagamentoComBoleto;
import com.example.cruso1.domain.PagamentoComCartao;
import com.example.cruso1.domain.Pedido;
import com.example.cruso1.domain.Produto;
import com.example.cruso1.domain.enums.EstadoPagamento;
import com.example.cruso1.domain.enums.TipoCliente;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoria;
	@Autowired
	private ProdutoRepository produto;
	@Autowired
	private EstadoRepository estado;
	@Autowired
	private CidadeRepository cidade;
	@Autowired
	private EnderecoRepository endereco;
	@Autowired
	private ClienteRepository cliente;
	@Autowired
	private PedidoRepository pedido;
	@Autowired
	private PagamentoRepository pagamento;
	@Autowired
	private ItemPedidoRepository itemPedido;
	
	
	
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
		 
		 Estado est1 = new Estado(null, "estado");
		 Estado est2 = new Estado(null, "2estado");
		 
		 Cidade cid1 = new Cidade(null, "cidade", est1);
		 Cidade cid2 = new Cidade(null, "2cidade", est2);
		 Cidade cid3 = new Cidade(null, "3cidade", est2);
		 
		 est1.getCidades().addAll(Arrays.asList(cid1));
		 est2.getCidades().addAll(Arrays.asList(cid1, cid3));
		 
		 estado.saveAll(Arrays.asList(est1,est2));
		 cidade.saveAll(Arrays.asList(cid1,cid2,cid3));
		 
		 Cliente cli1 = new Cliente(null, "nome", "email", "cpfOuCnpj",TipoCliente.PESSOAFISICA);
		 cli1.getTelefones().addAll(Arrays.asList("3261001","4294313"));
		 Endereco e1 = new Endereco(null, "logradouro", "numero", "complemento", "bairro", "cep", cli1 , cid1);
		 Endereco e2 = new Endereco(null, "2logradouro", "2numero", "2complemento", "2bairro", "2cep", cli1 , cid2);
		 cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		 cliente.saveAll(Arrays.asList(cli1));
		 endereco.saveAll(Arrays.asList(e1,e2));
		 
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		 
		 Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		 Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		 
		 Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		 ped1.setPagamento(pagto1);
		 Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"),null);
		 ped2.setPagamento(pagto2);
		 
		 cli1.getPedido().addAll(Arrays.asList(ped1,ped2));
		 
		 pedido.saveAll(Arrays.asList(ped1,ped2));
		 pagamento.saveAll(Arrays.asList(pagto1,pagto2));
		 
		 ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		 ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		 ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		 
		 ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		 ped2.getItens().addAll(Arrays.asList(ip3));
		 
		 p1.getItens().addAll(Arrays.asList(ip1));
		 p2.getItens().addAll(Arrays.asList(ip3));
		 p3.getItens().addAll(Arrays.asList(ip2));
		 
		 itemPedido.saveAll(Arrays.asList(ip1,ip2,ip3));
		 
	}

}
