package ru.itis.shop.app;

import ru.itis.shop.users.controllers.UsersUIConsole;
import ru.itis.shop.users.repositories.UsersRepository;
import ru.itis.shop.users.repositories.impl.UsersRepositoryListImpl;
import ru.itis.shop.users.services.UsersService;
import ru.itis.shop.users.validators.EmailValidator;
import ru.itis.shop.users.validators.SimpleEmailValidator;

/**
 * Shop
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Main {
    // сборка компонентов системы и клиентский код
    public static void main(String[] args) {
//        UsersRepository usersRepository = new UsersRepositoryFileImpl("users.txt");
        EmailValidator emailValidator = new SimpleEmailValidator();
        UsersRepository usersRepository = new UsersRepositoryListImpl();
        UsersService usersService = new UsersService(usersRepository, emailValidator);
        UsersUIConsole ui = new UsersUIConsole(usersService);
        ui.printRegistrationMenu();
    }
}
