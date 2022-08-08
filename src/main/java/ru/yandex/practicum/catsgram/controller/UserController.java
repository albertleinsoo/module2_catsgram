package ru.yandex.practicum.catsgram.controller;

import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.exeptions.InvalidEmailException;
import ru.yandex.practicum.catsgram.exeptions.UserAlreadyExistException;
import ru.yandex.practicum.catsgram.model.User;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private Map<String, User> users = new HashMap<>();

    @GetMapping
    public List<User> listUsers() {
        return new ArrayList<>(users.values());
    }

    @PostMapping
    public User create(@RequestBody User user) {
        //Если в переданных данных отсутствует адрес электронной почты (например, равен null или пустой строке), то генерируется исключение InvalidEmailException
        if (user.getEmail() == null || user.getEmail().equals("")){
            throw new InvalidEmailException("Некорректный email пользователя");
        }
        //Если пользователь с указанным адресом электронной почты уже был добавлен ранее, то генерируется исключениеUserAlreadyExistException
        if (users.containsKey(user.getEmail())) {
            throw new UserAlreadyExistException("Пользователь уже существует");
        }
        users.put(user.getEmail(), user);
        return user;
    }

    @PutMapping
    public User saveUser(@RequestBody User user) {
        //Если в переданных данных отсутствует адрес электронной почты (например, равен null или пустой строке), то генерируется исключение InvalidEmailException
        if (user.getEmail() == null || user.getEmail().equals("")){
            throw new InvalidEmailException("Некорректный email пользователя");
        }

        users.put(user.getEmail(), user);
        return user;
    }
}
