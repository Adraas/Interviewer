package ru.wkn.exceptions;

/**
 * The class {@code EntityException} represents the custom exception for the indicating violations in the
 * entities creating context.
 *
 * @author Orin Adraas
 */
public class EntityException extends Exception {

    /**
     * @see Exception#Exception(String)
     */
    public EntityException(String message) {
        super("Entity creating exception cause: ".concat(message));
    }
}
