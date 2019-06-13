package ru.wkn.repository.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.wkn.exceptions.PersistenceException;
import ru.wkn.repository.dao.IDao;

import java.io.Serializable;
import java.util.Collection;

/**
 * The class {@code Service} represents the business-logic service implementation for the repository by means DAO
 * layout.
 *
 * @author Orin Adraas
 * @see IService
 */
@AllArgsConstructor
@Getter
public class Service<V, I extends Serializable> implements IService<V, I> {

    /**
     * The {@code IDao} object represents a DAO layout implementation.
     */
    private IDao<V, I> dao;

    /**
     * @see IDao#create(V)
     */
    @Override
    public boolean create(V newInstance) throws PersistenceException {
        return dao.create(newInstance);
    }

    /**
     * @see IDao#read(I)
     */
    @Override
    public V read(I index) {
        return dao.read(index);
    }

    /**
     * @see IDao#update(V)
     */
    @Override
    public boolean update(V transientInstance) throws PersistenceException {
        return dao.update(transientInstance);
    }

    /**
     * @see IDao#delete(V)
     */
    @Override
    public boolean delete(V transientInstance) throws PersistenceException {
        return dao.delete(transientInstance);
    }

    /**
     * @see IDao#getAll()
     */
    @Override
    public Collection<V> getAll() {
        return dao.getAll();
    }
}
