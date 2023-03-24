package com.example.user_register_ee.manager;


import com.example.user_register_ee.models.User;

public interface UserManager {

    boolean existByEmail(String email);

    User save(User user);

    User getByEmailAndPassword(String email,
                               String password);

    User getById(int id);

    void verify(User user);
}
