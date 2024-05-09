package com.corso.shop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.corso.shop.models.User;

public interface UserRepository extends MongoRepository<User, String> {

}
