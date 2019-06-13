package ru.wkn.repository.service;

import ru.wkn.entities.user.User;
import ru.wkn.exceptions.PersistenceException;
import ru.wkn.repository.dao.IDao;
import ru.wkn.repository.dao.h2.H2UserDao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserService extends Service<User, Long> {

    public UserService(IDao<User, Long> dao) {
        super(dao);
    }

    public User getUserByEmailAndPassword(String email, String password) throws PersistenceException {
        return ((H2UserDao) getDao()).getUserByEmailAndPassword(email, password);
    }

    public String registryCookie(String name, String email, String password) {
        byte[] startMessage = name.concat(email).concat(password).getBytes();
        String codeMessage = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            codeMessage = new String(messageDigest.digest(startMessage));
            while (((H2UserDao) getDao()).isCookieExist(codeMessage)) {
                codeMessage = new String(messageDigest.digest(new String(startMessage).concat(codeMessage).getBytes()));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return codeMessage;
    }
}
