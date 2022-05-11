package com.spring.mvc.crudapp.Service;

import com.spring.mvc.crudapp.model.User;

import java.util.List;

public interface UserService {

    List<User> getListUsers();

    void addUser(User user);

    User findById(Long id);

    void deleteUserById(Long id);

    void update(Long id, User user);
}
