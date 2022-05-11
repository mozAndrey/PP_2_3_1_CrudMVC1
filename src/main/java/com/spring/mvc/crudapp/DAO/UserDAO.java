package com.spring.mvc.crudapp.DAO;

import com.spring.mvc.crudapp.model.User;

import java.util.List;
public interface UserDAO {

    List<User> getListOfUsers();

    void addUser(User user);

    User findById(Long id);

    void deleteById(Long id);

    void update(Long id, User user);
}
