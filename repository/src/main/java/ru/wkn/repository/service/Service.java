package ru.wkn.repository.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.wkn.exceptions.PersistenceException;
import ru.wkn.repository.dao.IDao;

import java.io.Serializable;
import java.util.Collection;

@AllArgsConstructor
@Getter
public class Service<V, I extends Serializable> implements IService<V, I> {

    private IDao<V, I> dao;

    @Override
    public boolean create(V newInstance) throws PersistenceException {
        return dao.create(newInstance);
    }

    @Override
    public V read(I index) {
        return dao.read(index);
    }

    @Override
    public boolean update(V transientInstance) throws PersistenceException {
        return dao.update(transientInstance);
    }

    @Override
    public boolean delete(V transientInstance) throws PersistenceException {
        return dao.delete(transientInstance);
    }

    @Override
    public Collection<V> getAll() {
        return dao.getAll();
    }
}
