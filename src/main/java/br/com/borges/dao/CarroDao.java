package br.com.borges.dao;

import java.awt.Robot;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.borges.domain.Carro;

public class CarroDao implements ICarroDao {
	
	

	@Override
	public Carro cadastrar(Carro carro) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjJPA_Mod33");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(carro);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
		return carro;
	}

	@Override
	public void excluir(Carro carro) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjJPA_Mod33");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.find(Carro.class, carro.getId());
		entityManager.remove(carro);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();

	}

	@Override
	public List<Carro> buscarTodos() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjJPA_Mod33");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Carro> query = builder.createQuery(Carro.class);
		Root<Carro> root = query.from(Carro.class);
		query.select(root);

		TypedQuery<Carro> tpQuery = entityManager.createQuery(query);
		List<Carro> list = tpQuery.getResultList();

		entityManager.close();
		entityManagerFactory.close();
		return list;
	}

}
