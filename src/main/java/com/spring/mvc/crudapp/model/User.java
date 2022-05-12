package com.spring.mvc.crudapp.model;


import javax.persistence.*;
import java.util.logging.Logger;

@Entity
@Table
public class User {

    private final static Logger LOGGER = Logger.getLogger(User.class.getName());
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    public Long getId() {
        return id;
    }

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private String email;

    public User() {
        LOGGER.info("CONSTRUCTOR without params ");
    }

    public User(String name, String lastName, String email) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        LOGGER.info("CONSTRUCTOR with params" + " " + name + " " + lastName + " " + email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
