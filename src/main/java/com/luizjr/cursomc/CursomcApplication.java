package com.luizjr.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.luizjr.cursomc.domain.Categoria;
import com.luizjr.cursomc.domain.Cidade;
import com.luizjr.cursomc.domain.Cliente;
import com.luizjr.cursomc.domain.Endereco;
import com.luizjr.cursomc.domain.Estado;
import com.luizjr.cursomc.domain.Pagamento;
import com.luizjr.cursomc.domain.Pedido;
import com.luizjr.cursomc.domain.PgtoComBoleto;
import com.luizjr.cursomc.domain.PgtoComCartao;
import com.luizjr.cursomc.domain.Produto;
import com.luizjr.cursomc.domain.enums.EstadoPagamento;
import com.luizjr.cursomc.domain.enums.TipoCliente;
import com.luizjr.cursomc.repositories.CategoriaRepository;
import com.luizjr.cursomc.repositories.CidadeRepository;
import com.luizjr.cursomc.repositories.ClienteRepository;
import com.luizjr.cursomc.repositories.EnderecoRepository;
import com.luizjr.cursomc.repositories.EstadoRepository;
import com.luizjr.cursomc.repositories.PagamentoRepository;
import com.luizjr.cursomc.repositories.PedidoRepository;
import com.luizjr.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		//------ Estado e Cidades
		
		Estado est1 = new Estado(null, "Tocantins");
		Estado est2 = new Estado(null, "Goiás");
		
		Cidade cid1 = new Cidade(null, "Palmas", est1);
		Cidade cid2 = new Cidade(null, "Goiânia", est2);
		Cidade cid3 = new Cidade(null, "Anapolis", est2);
		
		est1.getCidades().addAll(Arrays.asList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2, cid3));
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
		
		// Clientes, endereços e telefone
		Cliente cli1 = new Cliente(null, "Luiz Júnior", "luiz09@hotmail.com", "64274209172", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("63984095737","63222523212"));
		
		Endereco e1 = new Endereco(null, "706 Sul Al25", "13", "Casa 31", "Pds", "77022-400", cli1, cid1);
		Endereco e2 = new Endereco(null, "Rua 8", "Tripoli", "Apto 306", "Centro", "77060-500", cli1, cid2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		//Pedidos
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:38"), cli1, e2);
		
		Pagamento pgto1 = new PgtoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pgto1);
		
		Pagamento pgto2 = new PgtoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pgto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pgto1, pgto2));
	}

}
