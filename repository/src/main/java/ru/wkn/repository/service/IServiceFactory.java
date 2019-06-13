package ru.wkn.repository.service;

import ru.wkn.repository.dao.IDao;
import ru.wkn.repository.util.EntityInstanceType;

/**
 * The interface {@code IServiceFactory} represents the abstract factory for the service layout.
 *
 * @author Orin Adraas
 */
public interface IServiceFactory {

    /**
     * The abstract factory method for the {@code IService} object creating.
     *
     * @param entityInstanceType the enum object represents datasource name
     * @param dao                the {@code IDao} object represents a DAO layout implementation
     * @return the newly created {@code IService} object or {@code null} if there is no matching between
     *         {@code entityInstanceType} and existed service's implementation
     */
    IService createService(EntityInstanceType entityInstanceType, IDao dao);
}
