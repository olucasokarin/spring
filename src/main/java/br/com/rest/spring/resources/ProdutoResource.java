package br.com.rest.spring.resources;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rest.spring.model.Produto;
import br.com.rest.spring.repository.ProdutoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api("API REST Produtos")
@CrossOrigin(origins = "*")
public class ProdutoResource {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	
	@GetMapping("/produto")
	@ApiOperation(value = "Retorna uma lista")
	public List<Produto> listaProdutos(){
		return produtoRepository.findAll();
	}
	
	
	@GetMapping("/produto/{id}")
	@ApiOperation(value = "Retorna um produto")
	public Produto pegaProduto(@PathVariable("id") long id) {
		return produtoRepository.findById(id);
		
	}
	
	@PostMapping("/produto")
	@ApiOperation(value = "cadastra um produto")
	public Produto salvaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	
	//recebe um produto do corpo da requisicao
	@DeleteMapping("/produto")
	@ApiOperation(value = "apaga um produto")
	public void deletaProduto(@RequestBody Produto produto) {
		produtoRepository.delete(produto);
	}
	
	//recebe um id e procura no bd o obj e depois apaga
	@DeleteMapping("/produto/{id}")
	@ApiOperation(value = "apaga um produto com id")
	public void deletaProduto(@PathVariable long id) {
		Produto produto = produtoRepository.findById(id);
		produtoRepository.delete(produto);
	}
	
	@PutMapping("/produto")
	@ApiOperation(value = "atualiza um produto")
	public Produto atualizaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

}
