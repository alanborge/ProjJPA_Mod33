package br.com.borges.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.borges.domain.Acessorio;
import br.com.borges.domain.Marca;

public class AcessorioDao implements IAcessorioDao {

	@Override
	public Acessorio cadastrar(Acessorio acessorio) {
		EntityManagerFactory entityManagerFactory =
				Persistence.createEntityManagerFactory("ProjJPA_Mod33");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(acessorio);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
		return acessorio;
	}

	@Override
	public void excluir(Acessorio acessorio) {
		EntityManagerFactory entityManagerFactory =
				Persistence.createEntityManagerFactory("ProjJPA_Mod33");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.remove(acessorio);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
	}

	@Override
	public List<Acessorio> buscarTodos() {
		EntityManagerFactory entityManagerFactory =
				Persistence.createEntityManagerFactory("ProjJPA_Mod33");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Acessorio> query = builder.createQuery(Acessorio.class);
		Root<Acessorio> root = query.from(Acessorio.class);
		query.select(root);
		
		TypedQuery<Acessorio> tpQuery =
				entityManager.createQuery(query);
		List<Acessorio> list = tpQuery.getResultList();
		
		entityManager.close();
		entityManagerFactory.close();
		return list;
	}

	

}
