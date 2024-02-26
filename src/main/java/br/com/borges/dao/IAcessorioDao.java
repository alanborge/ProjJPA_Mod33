package br.com.borges.dao;

import java.util.List;

import br.com.borges.domain.Acessorio;



public interface IAcessorioDao {

   Acessorio cadastrar (Acessorio acessorio);
	
	void excluir(Acessorio acessorio);
	
	List<Acessorio>buscarTodos();

}
