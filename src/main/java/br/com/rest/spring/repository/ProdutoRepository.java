package br.com.rest.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rest.spring.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	Produto findById(long id);
}
