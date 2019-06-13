package ru.wkn;

import lombok.Getter;
import ru.wkn.repository.service.IService;
import ru.wkn.repository.service.IServiceFactory;
import ru.wkn.repository.service.ServiceFactory;
import ru.wkn.repository.util.DAORepository;
import ru.wkn.repository.util.EntityInstanceType;

/**
 * The class {@code RepositoryFacade} represents Facade pattern for the repository module.
 *
 * @author Orin Adraas
 */
public class RepositoryFacade {

    @Getter
    private String persistenceUnitName;
    @Getter
    private EntityInstanceType entityInstanceType;

    private IServiceFactory serviceFactory;
    @Getter
    private IService service;

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

    public void setPersistenceUnitName(String persistenceUnitName) {
        this.persistenceUnitName = persistenceUnitName;
        serviceReinitialize();
    }

    public void setEntityInstanceType(EntityInstanceType entityInstanceType) {
        this.entityInstanceType = entityInstanceType;
        serviceReinitialize();
    }
}
