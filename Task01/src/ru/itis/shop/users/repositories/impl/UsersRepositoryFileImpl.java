package ru.itis.shop.users.repositories.impl;

import ru.itis.shop.users.models.User;
import ru.itis.shop.users.repositories.UsersRepository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * Shop
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class UsersRepositoryFileImpl implements UsersRepository {
    private final String fileName;

    public UsersRepositoryFileImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void save(User user) {
        // try-with-resources
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))){
            writer.write(user.getId() + "|" + user.getName() + "|" + user.getEmail() + "|" + user.getPassword());
            writer.newLine();
        } catch (IOException e) { // перехватываю проверяемое исключение
            throw new IllegalStateException(e); // пробрасываем непроверяемое поверх, чтобы остановить цикл работы программы
        }
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.empty();
    }
}
