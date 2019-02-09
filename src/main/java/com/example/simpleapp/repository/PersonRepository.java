package com.example.simpleapp.repository;

import com.example.simpleapp.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findFirstById(Long id);

    @Transactional
    @Modifying
    @Query(nativeQuery=true, value="update person SET first_name=?1, last_name=?2, email=?3 WHERE id=?4")
    void setPersonDataById(String name, String lastName, String email, Long userId);
}
