package ru.wkn.exceptions;

public class PersistenceException extends Exception {

    public PersistenceException(String message, Throwable cause) {
        super("Persistence context fail cause: ".concat(message), cause);
    }
}
