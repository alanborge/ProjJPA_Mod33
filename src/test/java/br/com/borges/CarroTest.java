package br.com.borges;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.borges.dao.AcessorioDao;
import br.com.borges.dao.CarroDao;
import br.com.borges.dao.IAcessorioDao;
import br.com.borges.dao.ICarroDao;
import br.com.borges.dao.IMarcaDao;
import br.com.borges.dao.MarcaDao;
import br.com.borges.domain.Acessorio;
import br.com.borges.domain.Carro;

import br.com.borges.domain.Marca;

public class CarroTest {
	
	private ICarroDao carroDao;
	private IMarcaDao marcaDao;
	private IAcessorioDao acessorioDao;
	
	public CarroTest() {
		 carroDao = new CarroDao();
	     marcaDao = new MarcaDao();
	     acessorioDao = new AcessorioDao();    
	}
	
	@Test
	public void cadastrar() {
		// Cria uma nova marca
        Marca marca = new Marca();
        marca.setCodigo("ABC127"); // Define um código válido para a marca
        marca.setNome("Chevrolet");
        
        // Salva a marca antes de associá-la ao carro
        marca = marcaDao.cadastrar(marca);
        
        assertNotNull("A marca não pode ser nula", marca);
        assertNotNull("O ID da marca não pode ser nulo", marca.getId());
        
        // Cria um novo acessório
        Acessorio acessorio = new Acessorio();
        acessorio.setCodigo("ACC003");
        acessorio.setNome("Airbag");
        
        // Salva o acessório antes de associá-lo ao carro
        acessorio = acessorioDao.cadastrar(acessorio);
        
        assertNotNull("O acessório não pode ser nulo", acessorio);
        assertNotNull("O ID do acessório não pode ser nulo", acessorio.getId());
             
        
        // Cria um novo carro
        Carro carro = new Carro();
        carro.setCodigo("A396");
        carro.setModelo("Onix LT");
        carro.setMarca(marca); // Associa a marca criada ao carro
        
        // Salva o carro
        carro = carroDao.cadastrar(carro);
        
        assertNotNull("O carro não pode ser nulo", carro);
        assertNotNull("O ID do carro não pode ser nulo", carro.getId());
        
        // Associa os acessórios ao carro
        List<Acessorio> acessorios = new ArrayList<>();
        acessorios.add(acessorio);
               
        List<Carro> carros = carroDao.buscarTodos();
        assertNotNull("A lista de carros não pode ser nula", carros);
        
        List<Marca> marcas = marcaDao.buscarTodos();
        assertNotNull(marcas);
        
      
       carroDao.excluir(carro);
                   
	}
		 
}
