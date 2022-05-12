package com.spring.mvc.crudapp.Service;

import com.spring.mvc.crudapp.DAO.UserDAO;
import com.spring.mvc.crudapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getListUsers() {
        return userDAO.getListOfUsers();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public User findById(Long id) {
        User user = userDAO.findById(id);
        user.setId(id);
        return user;
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        userDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void update(User user) {
        userDAO.update(user);
    }
}
