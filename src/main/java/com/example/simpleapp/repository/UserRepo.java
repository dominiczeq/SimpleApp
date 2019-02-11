package com.example.simpleapp.repository;

import com.example.simpleapp.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
}
