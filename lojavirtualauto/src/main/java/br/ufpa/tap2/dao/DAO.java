package br.ufpa.tap2.dao;

import br.ufpa.tap2.exception.AcessoDBError;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@SuppressWarnings("unchecked")
public abstract class DAO<T> implements DAOLocal<T> {

	 @PersistenceContext(name = "tap2PU")
	 private EntityManager em;

	@Override
	public void salvar(T entity) throws AcessoDBError {
		em.persist(entity);
	}

	@Override
	public void atualizar(T entity) throws AcessoDBError {
		em.merge(entity);
	}

	@Override
	public void remover(Serializable id, Class<T> clazz) throws AcessoDBError {
		em.remove(getUm(id, clazz));
	}

	@Override
	public T getUm(Serializable id, Class<T> clazz) throws AcessoDBError {
		T retorno = (T) em.find(clazz, id);
		return retorno;
	}

	
	@Override
	public List<T> listar(Class<T> clazz) throws AcessoDBError {
		List<T> list = em.createQuery("Select t from " + clazz.getSimpleName() + " t")
		.getResultList();
		return list;
	}

	public EntityManager getEm() {
		return em;
	}

	
	
}