package com.corso.shop.services.interfaces;

import java.util.*;

import com.corso.shop.models.User;

public interface UserService {

    List<User> findAll();

    Optional<User> findById(String id);

    User save(User user);

    User findByEmail(String email);
}
