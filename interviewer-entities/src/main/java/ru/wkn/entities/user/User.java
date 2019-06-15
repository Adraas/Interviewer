package ru.wkn.entities.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The class {@code User} represents information about user of the system.
 *
 * @author Orin Adraas
 */
@NoArgsConstructor
@Getter
@Setter
public class User {

    /**
     * The unique ID of an user.
     */
    private long id;

    /**
     * The pseudo-name or real name of an user.
     */
    private String name;

    /**
     * The email of an user.
     */
    private String email;

    /**
     * The password of an user account.
     */
    private String password;

    /**
     * The cookie for the unique indicating an user in the system.
     */
    private String cookie;

    /**
     * Initializes a newly created {@code User} object with the given parameter assignments to the fields of
     * an {@code User} object.
     *
     * @param name {@link #name}
     * @param email {@link #email}
     * @param password {@link #password}
     * @param cookie {@link #cookie}
     */
    public User(String name, String email, String password, String cookie) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.cookie = cookie;
    }
}
