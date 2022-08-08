package ru.yandex.practicum.catsgram.exeptions;

public class InvalidEmailException extends RuntimeException {
    public InvalidEmailException(final String message) {
        super(message);
    }
}
