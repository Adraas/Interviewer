package ru.wkn.repository.dao;

import org.hibernate.Session;
import ru.wkn.repository.util.EntityInstanceType;

import java.io.Serializable;

/**
 * The interface {@code IDaoFactory} represents abstract factory for the DAO layout.
 *
 * @param <V> the type of the persistence object
 * @param <I> the type of the index for working with persistence object
 * @author Orin Adraas
 */
public interface IDaoFactory<V, I extends Serializable> {

    /**
     * The abstract factory method for the {@code IDao} object creating.
     *
     * @param entityInstanceType the enum object represents datasource name
     * @param session the object represents a connection session
     * @return the newly created {@code IDao} object
     */
    IDao<V, I> createDao(EntityInstanceType entityInstanceType, Session session);
}
