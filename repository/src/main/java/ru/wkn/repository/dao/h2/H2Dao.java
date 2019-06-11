package ru.wkn.repository.dao.h2;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.wkn.exceptions.PersistenceException;
import ru.wkn.repository.dao.EntityInstanceType;
import ru.wkn.repository.dao.IDao;

import javax.persistence.Query;
import javax.persistence.RollbackException;
import java.io.Serializable;
import java.util.Collection;

@AllArgsConstructor
@Log
public class H2Dao<V, I extends Serializable> implements IDao<V, I> {

    private Class<V> instanceClass;
    private Session session;
    private EntityInstanceType entityInstanceType;

    @Override
    public boolean create(V newInstance) throws PersistenceException {
        Transaction transaction = session.beginTransaction();
        try {
            session.save(newInstance);
            transaction.commit();
        } catch (RollbackException e) {
            transaction.rollback();
            String message = "Element ".concat(newInstance.toString()).concat(" not created");
            log.warning(message);
            throw new PersistenceException(message, e);
        }
        return true;
    }

    @Override
    public V read(I index) {
        return session.get(instanceClass, index);
    }

    @Override
    public boolean update(V transientInstance) throws PersistenceException {
        Transaction transaction = session.beginTransaction();
        try {
            session.update(transientInstance);
            transaction.commit();
        } catch (RollbackException e) {
            transaction.rollback();
            String message = "Element ".concat(transientInstance.toString()).concat(" not updated");
            log.warning(message);
            throw new PersistenceException(message, e);
        }
        return true;
    }

    @Override
    public boolean delete(V transientInstance) throws PersistenceException {
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(transientInstance);
            transaction.commit();
        } catch (RollbackException e) {
            transaction.rollback();
            String message = "Element ".concat(transientInstance.toString()).concat(" not deleted");
            log.warning(message);
            throw new PersistenceException(message, e);
        }
        return true;
    }

    @SuppressWarnings(value = {"unchecked"})
    @Override
    public Collection<V> getAll() {
        Query query = session.createSQLQuery("SELECT * FROM ".concat(entityInstanceType.getEntityType()));
        return query.getResultList();
    }
}
