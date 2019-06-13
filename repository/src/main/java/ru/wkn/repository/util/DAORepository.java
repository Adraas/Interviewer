package ru.wkn.repository.util;

import ru.wkn.repository.dao.DaoFactory;
import ru.wkn.repository.dao.IDao;
import ru.wkn.repository.dao.IDaoFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * The class {@code DAORepository} represents the DAO implementations repository.
 *
 * @author Orin Adraas
 */
public class DAORepository {

    /**
     * The {@code Map} collection with DAO implementations.
     */
    private static Map<EntityInstanceType, IDao> daoMap;

    /**
     * The factory for the creating a new DAO implementation.
     */
    private static IDaoFactory daoFactory;

    static {
        daoMap = new HashMap<>();
        daoFactory = new DaoFactory();
    }

    /**
     * @see Map#put(Object, Object)
     */
    public static void addDao(EntityInstanceType entityInstanceType, IDao dao) {
        daoMap.put(entityInstanceType, dao);
    }

    /**
     * The method for the getting an existed DAO implementation with an opportunity to create a not existed required
     * object.
     *
     * @see Map#get(Object)
     */
    public static IDao getDao(String persistenceUnitName, EntityInstanceType entityInstanceType) {
        if (!daoMap.containsKey(entityInstanceType)) {
            IDao dao = daoFactory.createDao(entityInstanceType, SessionRepository.getSession(persistenceUnitName));
            addDao(entityInstanceType, dao);
        }
        return daoMap.get(entityInstanceType);
    }
}
