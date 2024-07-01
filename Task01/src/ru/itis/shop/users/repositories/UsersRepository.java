package ru.itis.shop.users.repositories;

import ru.itis.shop.users.models.User;

import java.util.List;
import java.util.Optional;

/**
 * Shop
 *
 * @author Marsel Sidikov (AIT TR)
 */
public interface UsersRepository {
    void save(User user);

    List<User> findAll();

    void update(User user);

    void delete(String id);

    Optional<User> findById(String id);
}
