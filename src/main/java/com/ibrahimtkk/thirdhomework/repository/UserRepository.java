package com.ibrahimtkk.thirdhomework.repository;

import com.ibrahimtkk.thirdhomework.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}