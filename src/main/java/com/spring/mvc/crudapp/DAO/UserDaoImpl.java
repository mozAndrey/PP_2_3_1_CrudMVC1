package com.spring.mvc.crudapp.DAO;

import com.spring.mvc.crudapp.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getListOfUsers() {
       List<User> list = entityManager.createQuery("select user from User user", User.class).getResultList();
        return list;
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public void deleteById(Long id) {
        entityManager.remove(entityManager.find(User.class,id));
    }

    @Override
    public void update(Long id, User user) {
        User user1 = entityManager.find(User.class,id);
        user1.setName(user.getName());
        user1.setLastName(user.getLastName());
        user1.setEmail(user.getEmail());
    }


}
