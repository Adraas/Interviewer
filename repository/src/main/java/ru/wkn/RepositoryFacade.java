package ru.wkn;

import lombok.Getter;
import ru.wkn.repository.service.IService;
import ru.wkn.repository.service.IServiceFactory;
import ru.wkn.repository.service.ServiceFactory;
import ru.wkn.repository.util.DAORepository;
import ru.wkn.repository.util.EntityInstanceType;

/**
 * The class {@code RepositoryFacade} represents the facade pattern for this module.
 *
 * @author Orin Adraas
 */
public class RepositoryFacade {

    /**
     * The persistence-unit name for the configuration indicating.
     */
    @Getter
    private String persistenceUnitName;

    /**
     * The enum object represents datasource name.
     */
    @Getter
    private EntityInstanceType entityInstanceType;

    /**
     * The factory for the {@code IService} objects creating.
     */
    private IServiceFactory serviceFactory;

    /**
     * The service for the working with the given datasource.
     */
    @Getter
    private IService service;

    /**
     * Initializes a newly created {@code RepositoryFacade} object with the given parameter assignments to the fields of
     * an {@code RepositoryFacade} object.
     *
     * @param persistenceUnitName {@link #persistenceUnitName}
     * @param entityInstanceType  {@link #entityInstanceType}
     */
    public RepositoryFacade(String persistenceUnitName, EntityInstanceType entityInstanceType) {
        this.persistenceUnitName = persistenceUnitName;
        this.entityInstanceType = entityInstanceType;
        serviceFactory = new ServiceFactory();
        serviceReinitialize();
    }

    private void serviceReinitialize() {
        service = serviceFactory.createService(entityInstanceType,
                DAORepository.getDao(persistenceUnitName, entityInstanceType));
    }

    /**
     * The method for the setting new value for the {@link #persistenceUnitName} field with the resetting
     * a {@link #service} field.
     *
     * @param persistenceUnitName {@link #persistenceUnitName}
     */
    public void setPersistenceUnitName(String persistenceUnitName) {
        this.persistenceUnitName = persistenceUnitName;
        serviceReinitialize();
    }

    /**
     * The method for the setting new value for the {@link #entityInstanceType} field with the resetting
     * a {@link #service} field.
     *
     * @param entityInstanceType {@link #entityInstanceType}
     */
    public void setEntityInstanceType(EntityInstanceType entityInstanceType) {
        this.entityInstanceType = entityInstanceType;
        serviceReinitialize();
    }
}
