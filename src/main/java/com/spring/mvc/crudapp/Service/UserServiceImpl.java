package com.spring.mvc.crudapp.Service;

import com.spring.mvc.crudapp.DAO.UserDAO;
import com.spring.mvc.crudapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    @Transactional
    public List<User> getListUsers() {
        return userDAO.getListOfUsers();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    @Transactional
    public User findById(Long id) {
       return userDAO.findById(id);
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        userDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void update(Long id, User user) {
        userDAO.update(id,user);
    }
}
