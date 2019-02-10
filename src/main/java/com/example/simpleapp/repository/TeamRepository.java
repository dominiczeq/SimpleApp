package com.example.simpleapp.repository;

import com.example.simpleapp.entity.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long> {
}
