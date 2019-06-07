package ru.wkn.exceptions;

/**
 * The class {@code PersistenceException} represents custom exception for indicating violations in the persistence
 * context.
 *
 * @author Orin Adraas
 */
public class PersistenceException extends Exception {

    /**
     * @see Exception#Exception(String, Throwable)
     */
    public PersistenceException(String message, Throwable cause) {
        super("Persistence context fail cause: ".concat(message), cause);
    }
}
