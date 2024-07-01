package ru.itis.shop.users.validators;

/**
 * Shop
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class SimpleEmailValidator implements EmailValidator {

    @Override
    public void validate(String email) {
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Incorrect email");
        }
    }
}
