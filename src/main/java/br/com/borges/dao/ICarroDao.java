package br.com.borges.dao;

import java.util.List;

import br.com.borges.domain.Carro;



public interface ICarroDao {
	
    Carro cadastrar (Carro carro);
	
	void excluir(Carro carro);
	
	List<Carro>buscarTodos();

	

}
