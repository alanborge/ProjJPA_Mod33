package br.com.borges.dao;

import java.util.List;

import br.com.borges.domain.Carro;
import br.com.borges.domain.Marca;

public interface IMarcaDao {
	
    Marca cadastrar (Marca marca);
	
	void excluir(Marca marca);
	
	List<Marca>buscarTodos();


}
