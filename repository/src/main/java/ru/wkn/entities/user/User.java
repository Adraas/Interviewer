package ru.wkn.entities.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The class {@code User} represents information about user of the system.
 *
 * @author Orin Adraas
 */
@Entity
@Table(name = "user")
public class User {

    /**
     * The unique ID of user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, insertable = false, updatable = false)
    private long id;

    /**
     * The pseudo-name or real name of user.
     */
    @Column(name = "name", nullable = false, length = 60)
    private String name;

    /**
     * The email of user.
     */
    @Column(name = "email", unique = true, nullable = false, length = 60)
    private String email;

    /**
     * The password of user account.
     */
    @Column(name = "password", nullable = false, length = 60)
    private String password;

    /**
     * The cookie for the unique indicating user in the system.
     */
    @Column(name = "cookie", unique = true, nullable = false, length = 60)
    private String cookie;
}
