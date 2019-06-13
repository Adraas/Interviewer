package ru.wkn.repository.service;

import ru.wkn.repository.dao.IDao;
import ru.wkn.repository.util.EntityInstanceType;

public interface IServiceFactory {

    IService createService(EntityInstanceType entityInstanceType, IDao dao);
}
