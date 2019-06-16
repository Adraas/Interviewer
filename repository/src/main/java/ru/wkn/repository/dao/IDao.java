package ru.wkn.repository.dao;

import ru.wkn.exceptions.PersistenceException;

import java.io.Serializable;
import java.util.Collection;

/**
 * The interface {@code IDao} represents the abstract data access object layout between the application
 * and a repository.
 *
 * @param <V> the type of the persistence object
 * @param <I> the type of the index for working with persistence object
 * @author Orin Adraas
 */
public interface IDao<V, I extends Serializable> {

    /**
     * The method for the creating new persistence object in a repository.
     *
     * @param newInstance the instance of the persistence object
     * @return {@code true} if the object was saved success in a repository, else - {@code false}
     * @throws PersistenceException thrown if some problems with the object mapping
     */
    boolean create(V newInstance) throws PersistenceException;

    /**
     * The method for the reading a persistence object by means the given index from a repository.
     *
     * @param index the index for the searching a persistence object in a repository
     * @return found value or {@code null} if it not exist
     */
    V read(I index);

    /**
     * The method for the updating persistence object in a repository.
     *
     * @param transientInstance the instance of the persistence object containing updated state
     * @return {@code true} if the object was updated success in a repository, else - {@code false}
     * @throws PersistenceException thrown if some problems with the object mapping
     */
    boolean update(V transientInstance) throws PersistenceException;

    /**
     * The method for the deleting persistence object from a repository.
     *
     * @param transientInstance the instance of the persistence object to be removed
     * @return {@code true} if the object was deleted success from a repository, else - {@code false}
     * @throws PersistenceException thrown if some problems was occurred with the object mapping
     */
    boolean delete(V transientInstance) throws PersistenceException;

    /**
     * The method for the full sample statement fetch executing.
     *
     * @return the collection of the {@code Collection} type, contains an all persistence objects from a repository
     */
    Collection<V> getAll();
}
