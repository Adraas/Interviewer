package ru.wkn.entities.user;

/**
 * The class {@code User} represents information about user of the system.
 *
 * @author Orin Adraas
 */
public class User {

    /**
     * The unique ID of user.
     */
    private long id;

    /**
     * The pseudo-name or real name of user.
     */
    private String name;

    /**
     * The email of user.
     */
    private String email;

    /**
     * The password of user account.
     */
    private String password;

    /**
     * The cookie for the unique indicating user in the system.
     */
    private String cookie;
}
