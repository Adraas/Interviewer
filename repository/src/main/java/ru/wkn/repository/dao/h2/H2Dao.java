package ru.wkn.repository.dao.h2;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
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

/**
 * The class {@code H2Dao} represents the data access object layout implementation for the H2 Database.
 *
 * @see IDao
 * @author Orin Adraas
 */
@AllArgsConstructor
@Getter(value = AccessLevel.PROTECTED)
@Log
public class H2Dao<V, I extends Serializable> implements IDao<V, I> {

    /**
     * The meta-data about an entity object.
     */
    private Class<V> instanceClass;

    /**
     * The object represents a connection session.
     */
    private Session session;

    /**
     * The enum object represents an entity name
     */
    private EntityInstanceType entityInstanceType;

    /**
     * @see IDao#create(V)
     */
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

    /**
     * @see IDao#read(I)
     */
    @Override
    public V read(I index) {
        return session.get(instanceClass, index);
    }

    /**
     * @see IDao#update(V)
     */
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

    /**
     * @see IDao#delete(V)
     */
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

    /**
     * @see IDao#getAll()
     */
    @SuppressWarnings(value = {"unchecked"})
    @Override
    public Collection<V> getAll() {
        Query query = session.createSQLQuery("SELECT * FROM ".concat(entityInstanceType.getEntityName()));
        return query.getResultList();
    }
}
