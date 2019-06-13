package ru.wkn.repository.util;

import ru.wkn.repository.dao.DaoFactory;
import ru.wkn.repository.dao.IDao;
import ru.wkn.repository.dao.IDaoFactory;

import java.util.HashMap;
import java.util.Map;

public class DAORepository {

    private static Map<EntityInstanceType, IDao> daoMap;
    private static IDaoFactory daoFactory;

    static {
        daoMap = new HashMap<>();
        daoFactory = new DaoFactory();
    }

    public static void addDao(EntityInstanceType entityInstanceType, IDao dao) {
        daoMap.put(entityInstanceType, dao);
    }

    public static IDao getDao(String persistenceUnitName, EntityInstanceType entityInstanceType) {
        if (!daoMap.containsKey(entityInstanceType)) {
            IDao dao = daoFactory.createDao(entityInstanceType, SessionRepository.getSession(persistenceUnitName));
            addDao(entityInstanceType, dao);
        }
        return daoMap.get(entityInstanceType);
    }
}
