package ru.wkn.repository.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * The class {@code H2DatabaseJPAUtil} initializes configuration for a JPA ORM model with the given persistence unit
 * name for the {@code H2 Database} with the {@code Hibernate} provider.
 *
 * @author Orin Adraas
 */
public class H2DatabaseJPAUtil {

    /**
     * The persistence unit name indicated a JPA configuration.
     */
    private static final String PERSISTENCE_UNIT;

    /**
     * The {@code EntityManagerFactory} object for an {@code EntityManager} process creating ruling.
     */
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY;

    static {
        PERSISTENCE_UNIT = "questionnaires_h2_entity_manager";
        ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
    }

    /**
     * The getter for the {@code EntityManagerFactory} object.
     *
     * @return the value of the {@code ENTITY_MANAGER_FACTORY} field
     */
    public static EntityManagerFactory getEntityManagerFactory() {
        return ENTITY_MANAGER_FACTORY;
    }
}
