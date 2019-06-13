package ru.wkn.repository.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * The class {@code HibernateJPAContextInitializer} initializes configuration for a JPA ORM model with the given
 * persistence unit name for the {@code Hibernate} provider.
 *
 * @author Orin Adraas
 */
public class HibernateJPAContextInitializer {

    /**
     * The method for the getting an {@code EntityManagerFactory} object by the given persistence unit name.
     *
     * @param persistenceUnitName the persistence unit name indicated a JPA configuration
     * @return the value of a newly created {@code EntityManagerFactory} object
     */
    public static EntityManagerFactory getEntityManagerFactory(String persistenceUnitName) {
        return Persistence.createEntityManagerFactory(persistenceUnitName);
    }
}
