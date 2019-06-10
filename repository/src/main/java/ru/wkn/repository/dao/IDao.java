package ru.wkn.repository.dao;

import java.io.Serializable;
import java.util.Collection;

public interface IDao<V, I extends Serializable> {

    boolean create(V newInstance);

    V read(I index);

    boolean update(V transientInstance);

    boolean delete(V transientInstance);

    Collection<V> getAll();
}
