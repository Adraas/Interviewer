package ru.wkn.repository.service;

import ru.wkn.entities.user.User;
import ru.wkn.repository.dao.IDao;
import ru.wkn.repository.dao.h2.H2UserDao;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * The class {@code UserService} represents a special case for the {@code Service} using for a special needs for
 * the {@code User} entities.
 *
 * @author Orin Adraas
 * @see Service
 */
public class UserService extends Service<User, Long> {

    /**
     * Initializes a newly created {@code UserService} object with the given DAO implementation.
     *
     * @param dao the {@code IDao} object represents a DAO layout implementation
     */
    public UserService(IDao<User, Long> dao) {
        super(dao);
    }

    /**
     * The method for the getting {@code User} object by the given email and password (log-in process, for example)
     * from a repository by means the DAO layout implementation.
     *
     * @param email    the given email for the searching
     * @param password the given password for the searching
     * @return the searched object, casted to the {@code User} type
     */
    public User getUserByEmailAndPassword(String email, String password) {
        return ((H2UserDao) getDao()).getUserByEmailAndPassword(email, password);
    }

    /**
     * The method for the generating a new unique (for the table-level constraint) cookie value by means the
     * base64 algorithm with input parameters as the {@code name}, {@code email} and {@code password}.
     *
     * @param name     the given name for the generating cookie
     * @param email    the given email for the generating cookie
     * @param password the given password for the generating cookie
     * @return the generated unique cookie value as {@code String} object
     */
    public String generateCookie(String name, String email, String password) {
        byte[] startMessage = name.concat(email).concat(password).getBytes(StandardCharsets.UTF_8);
        Base64.Encoder encoder = Base64.getEncoder();
        String codedMessage = new String(encoder.encode(startMessage));
        while (((H2UserDao) super.getDao()).isCookieExists(codedMessage)) {
            codedMessage = new String(encoder.encode(codedMessage.getBytes(StandardCharsets.UTF_8)));
        }
        return codedMessage;
    }

    /**
     * The method for the checking to existence for the given cookie value in a DAO implementation.
     *
     * @param cookie the given cookie value as the {@code String} object for the checking
     * @return {@code true} if the given cookie value is exists in a DAO implementation, else - {@code false}
     */
    public boolean checkCookieToExist(String cookie) {
        return ((H2UserDao) super.getDao()).isCookieExists(cookie);
    }
}
