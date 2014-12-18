package com.imoiseyenko.spastructure.backend.repository.dao;

import java.lang.reflect.ParameterizedType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import com.imoiseyenko.spastructure.backend.repository.dao.GenericDAO;
import com.imoiseyenko.spastructure.backend.repository.exception.SpastructureDBRepositoryException;
import com.imoiseyenko.spastructure.backend.repository.exception.creator.SpastructureDBRepositoryExceptionCreator;

/**
 * Generic DAO implementation. Supports 2 ways of implementation. 1 - JPA - extends from Spring JPA
 * Support for easy access. 2 - JDBC - extends from Spring JDBC templates for complex queries.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Mar 31, 2014
 * @param <E>
 * @param <PK>
 */
@Transactional
public abstract class GenericDAOBean<E, PK> implements GenericDAO<E, PK> {

	/** Entity class. */
	private final Class<E> entityClass;

	/** JPA persistence entity manager. Used to perform JPA calls. */
	@PersistenceContext(name = "spastructurePersistenceUnit")
	protected EntityManager entityManager;

	/** Spring JDBC template. Used to perform plain JDBC calls. */
	protected JdbcTemplate jdbcTemplate;

	/**
	 * Instantiate object and define entity class.
	 * 
	 * @author imoiseyenko93@gmail.com
	 */
	@SuppressWarnings("unchecked")
	public GenericDAOBean () {

		try {
			this.entityClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass())
					.getActualTypeArguments()[0];
		} catch (ClassCastException ex) {
			throw new IllegalStateException(
					"Cannot create instance of class GenericDAO. You should extend from it and fill generic parameters or use constructor.",
					ex);
		}
	}

	/**
	 * Instantiate JDBC template with injected data source.
	 * 
	 * @param dataSource
	 * @author imoiseyenko93@gmail.com
	 */
	@Autowired
	public void setDataSource (DataSource dataSource) {

		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @author imoiseyenko93@gmail.com
	 */
	@Override
	public void create (E entity) throws SpastructureDBRepositoryException {

		try {
			entityManager.persist(entity);
		} catch (Exception ex) {
			throw SpastructureDBRepositoryExceptionCreator.CANNOT_CREATE_ENTITY.createException(ex);
		}
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @author imoiseyenko93@gmail.com
	 */
	@Override
	public E findById (PK pk) throws SpastructureDBRepositoryException {

		try {
			return entityManager.find(entityClass, pk);
		} catch (Exception ex) {
			throw SpastructureDBRepositoryExceptionCreator.CANNOT_FIND_ENTITY.createException(ex);
		}
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @author imoiseyenko93@gmail.com
	 */
	@Override
	public void update (E entity) throws SpastructureDBRepositoryException {

		try {
			entityManager.merge(entity);
		} catch (Exception ex) {
			throw SpastructureDBRepositoryExceptionCreator.CANNOT_UPDATE_ENTITY.createException(ex);
		}
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @author imoiseyenko93@gmail.com
	 */
	@Override
	public void delete (E entity) throws SpastructureDBRepositoryException {

		try {
			entityManager.remove(entity);
		} catch (Exception ex) {
			throw SpastructureDBRepositoryExceptionCreator.CANNOT_DELETE_ENTITY.createException(ex);
		}
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @author imoiseyenko93@gmail.com
	 */
	@Override
	public void deleteById (PK pk) throws SpastructureDBRepositoryException {

		try {
			entityManager.remove(entityManager.getReference(entityClass, pk));
		} catch (Exception ex) {
			throw SpastructureDBRepositoryExceptionCreator.CANNOT_DELETE_ENTITY.createException(ex);
		}
	}
}
