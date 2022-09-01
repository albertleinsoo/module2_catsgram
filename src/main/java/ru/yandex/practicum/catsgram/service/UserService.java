package ru.yandex.practicum.catsgram.service;

import org.springframework.stereotype.Service;
import ru.yandex.practicum.catsgram.exeptions.InvalidEmailException;
import ru.yandex.practicum.catsgram.exeptions.UserAlreadyExistException;
import ru.yandex.practicum.catsgram.model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    private Map<String, User> users = new HashMap<>();

    public Collection<User> findAll() {
        return users.values();
    }

    public User createUser(User user) {
        //Если в переданных данных отсутствует адрес электронной почты (например, равен null или пустой строке), то генерируется исключение InvalidEmailException
        if (user.getEmail() == null || user.getEmail().equals("")){
            throw new InvalidEmailException("Некорректный email пользователя");
        }
        //Если пользователь с указанным адресом электронной почты уже был добавлен ранее, то генерируется исключение UserAlreadyExistException
        if (users.containsKey(user.getEmail())) {
            throw new UserAlreadyExistException("Пользователь уже существует");
        }
        users.put(user.getEmail(), user);
        return user;
    }

    public User updateUser(User user) {
        //Если в переданных данных отсутствует адрес электронной почты (например, равен null или пустой строке), то генерируется исключение InvalidEmailException
        if (user.getEmail() == null || user.getEmail().equals("")){
            throw new InvalidEmailException("Некорректный email пользователя");
        }

        users.put(user.getEmail(), user);
        return user;
    }

    public User findUserByEmail(String email) {
        if (email == null) {
            return null;
        }
        return users.get(email);
    }
}
