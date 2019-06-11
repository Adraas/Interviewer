package ru.wkn.repository.dao;

import ru.wkn.exceptions.PersistenceException;

import java.io.Serializable;
import java.util.Collection;

public interface IDao<V, I extends Serializable> {

    boolean create(V newInstance) throws PersistenceException;

    V read(I index);

    boolean update(V transientInstance) throws PersistenceException;

    boolean delete(V transientInstance) throws PersistenceException;

    Collection<V> getAll();
}
