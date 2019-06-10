package ru.wkn.repository.dao;

import org.hibernate.Session;

import java.io.Serializable;

public class DaoFactory<V, I extends Serializable> implements IDaoFactory<V, I> {

    @Override
    public IDao<V, I> createDao(EntityInstanceType entityInstanceType, Session session) {
        return null;
    }
}
