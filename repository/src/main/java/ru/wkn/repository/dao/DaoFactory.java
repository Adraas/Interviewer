package ru.wkn.repository.dao;

import org.hibernate.Session;

import java.io.Serializable;

/**
 * The class {@code DaoFactory} represents implementation for the DAO layout factory.
 *
 * @see IDaoFactory
 * @author Orin Adraas
 */
public class DaoFactory<V, I extends Serializable> implements IDaoFactory<V, I> {

    /**
     * @see IDaoFactory#createDao(EntityInstanceType, Session)
     */
    @Override
    public IDao<V, I> createDao(EntityInstanceType entityInstanceType, Session session) {
        return null;
    }
}
