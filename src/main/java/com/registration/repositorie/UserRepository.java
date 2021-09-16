package com.registration.repositorie;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.registration.model.User;

public interface UserRepository extends MongoRepository<User, String>{

}
