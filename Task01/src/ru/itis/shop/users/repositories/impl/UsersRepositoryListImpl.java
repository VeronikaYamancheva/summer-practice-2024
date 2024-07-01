package ru.itis.shop.users.repositories.impl;

import ru.itis.shop.users.models.User;
import ru.itis.shop.users.repositories.UsersRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Shop
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class UsersRepositoryListImpl implements UsersRepository {
    private final List<User> usersList;

    public UsersRepositoryListImpl() {
        this.usersList = new ArrayList<>();
    }

    @Override
    public void save(User user) {
        this.usersList.add(user);

        // TODO: убрать
        System.out.println(usersList);
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
