package ru.itis.shop.app;

import ru.itis.shop.users.controllers.UsersUIConsole;
import ru.itis.shop.users.models.User;
import ru.itis.shop.users.repositories.UsersRepository;
import ru.itis.shop.users.repositories.impl.UsersRepositoryFileImpl;
import ru.itis.shop.users.services.UsersService;
import ru.itis.shop.users.validators.EmailValidator;
import ru.itis.shop.users.validators.SimpleEmailValidator;

import java.util.Optional;

/**
 * Shop
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Main {
    // сборка компонентов системы и клиентский код
    public static void main(String[] args) {
        UsersRepository usersRepository = new UsersRepositoryFileImpl("users.txt");
        EmailValidator emailValidator = new SimpleEmailValidator();
        UsersService usersService = new UsersService(usersRepository, emailValidator);
        UsersUIConsole ui = new UsersUIConsole(usersService);
        ui.printRegistrationMenu();

        Optional<User> userFoundedById = usersRepository.findById("fecfb50f-584b-44ee-8d63-0edfa5361e22");//marsel
        System.out.println(userFoundedById);
        System.out.println(usersRepository.findAll());
        usersRepository.delete("ad9f4f41-5406-42da-bd58-e58ece275d10"); //maxim
        usersRepository.update(new User("2cafff78-6164-4945-8049-ba27c5bad3f4", "misha", "misha.andreichev@mail.ru", "12345"));//razil -> misha
        System.out.println(usersRepository.findAll());

        usersRepository.update(new User("2cafff78-6164-4945-8049-ba27c5bad3f4", "razil", "razil@gmail.com", "qwerty008"));
        usersRepository.save(new User("ad9f4f41-5406-42da-bd58-e58ece275d10", "maxim", "maxim@gmail.com", "qwerty007"));
    }
}
