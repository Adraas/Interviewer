package ru.wkn.repository.dao;

import org.hibernate.Session;
import ru.wkn.repository.util.EntityInstanceType;

/**
 * The interface {@code IDaoFactory} represents the abstract factory for the DAO layout.
 *
 * @author Orin Adraas
 */
public interface IDaoFactory {

    /**
     * The abstract factory method for the {@code IDao} object creating.
     *
     * @param entityInstanceType the enum object represents datasource name
     * @param session            the object represents a connection session
     * @return the newly created {@code IDao} object or {@code null} if there is no matching between
     *         {@code entityInstanceType} and existed DAO implementation
     */
    IDao createDao(EntityInstanceType entityInstanceType, Session session);
}
