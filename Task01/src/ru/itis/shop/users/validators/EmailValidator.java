package ru.itis.shop.users.validators;

/**
 * Shop
 *
 * @author Marsel Sidikov (AIT TR)
 */
public interface EmailValidator {
    void validate(String email) throws IllegalArgumentException;
}
