package ru.itis.shop.users.repositories.impl;

import ru.itis.shop.users.models.User;
import ru.itis.shop.users.repositories.UsersRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return reader.lines()
                    .map(line -> line.split("\\|"))
                    .filter(userFieldsArray -> userFieldsArray.length == 4)
                    .map(userFieldsArray -> new User(userFieldsArray[0], userFieldsArray[1], userFieldsArray[2], userFieldsArray[3]))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalStateException();
        }
    }

    @Override
    public void update(User user) {
        List<User> users = findAll();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (User processUser : users) {
                if (!processUser.getId().equals(user.getId())) {
                    writer.write(processUser.getId() + "|" + processUser.getName() + "|" + processUser.getEmail() + "|" + processUser.getPassword());
                    writer.newLine();
                } else {
                    writer.write(user.getId() + "|" + user.getName() + "|" + user.getEmail() + "|" + user.getPassword());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void delete(String id) {
        List<User> users = findAll();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (User user : users) {
                if (!user.getId().equals(id)) {
                    writer.write(user.getId() + "|" + user.getName() + "|" + user.getEmail() + "|" + user.getPassword());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Optional<User> findById(String id) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return reader.lines()
                    .map(line -> line.split("\\|"))
                    .filter(userFieldsArray -> userFieldsArray[0].equals(id))
                    .map(userFieldsArray -> new User(userFieldsArray[0], userFieldsArray[1], userFieldsArray[2], userFieldsArray[3]))
                    .findFirst();
        } catch (IOException e) {
            throw new IllegalStateException();
        }
    }
}
