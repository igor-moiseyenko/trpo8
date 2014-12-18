package com.imoiseyenko.spastructure.backend.repository.dao;

import com.imoiseyenko.spastructure.backend.repository.exception.SpastructureDBRepositoryException;

/**
 * Generic DAO interface.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Mar 31, 2014
 * @param <E>
 * @param <PK>
 */
public interface GenericDAO<E, PK> {

	/**
	 * Persist entity to storage.
	 * 
	 * @param entity
	 * @throws SpastructureDBRepositoryException
	 * @author imoiseyenko93@gmail.com
	 */
	public void create (E entity) throws SpastructureDBRepositoryException;

	/**
	 * Find entity by primary key.
	 * 
	 * @param pk
	 * @return
	 * @throws SpastructureDBRepositoryException
	 * @author imoiseyenko93@gmail.com
	 */
	public E findById (PK pk) throws SpastructureDBRepositoryException;

	/**
	 * Update entity in storage.
	 * 
	 * @param entity
	 * @throws SpastructureDBRepositoryException
	 * @author imoiseyenko93@gmail.com
	 */
	public void update (E entity) throws SpastructureDBRepositoryException;

	/**
	 * Delete entity from storage.
	 * 
	 * @param entity
	 * @throws SpastructureDBRepositoryException
	 * @author imoiseyenko93@gmail.com
	 */
	public void delete (E entity) throws SpastructureDBRepositoryException;

	/**
	 * Delete entity from storage by primary key.
	 * 
	 * @param pk
	 * @throws SpastructureDBRepositoryException
	 * @author imoiseyenko93@gmail.com
	 */
	public void deleteById (PK pk) throws SpastructureDBRepositoryException;
}
