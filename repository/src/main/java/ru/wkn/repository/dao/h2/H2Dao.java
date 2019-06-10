package ru.wkn.repository.dao.h2;

import org.hibernate.Session;
import ru.wkn.repository.dao.EntityInstanceType;
import ru.wkn.repository.dao.IDao;

import java.io.Serializable;
import java.util.Collection;

public class H2Dao<V, I extends Serializable> implements IDao<V, I> {

    private Class<V> instanceClass;
    private Session session;
    private EntityInstanceType entityInstanceType;

    @Override
    public boolean create(V newInstance) {
        return false;
    }

    @Override
    public V read(I index) {
        return null;
    }

    @Override
    public boolean update(V transientInstance) {
        return false;
    }

    @Override
    public boolean delete(V transientInstance) {
        return false;
    }

    @Override
    public Collection<V> getAll() {
        return null;
    }
}
