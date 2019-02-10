package com.example.simpleapp.repository;

import com.example.simpleapp.entity.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository <Message, Long> {
}
