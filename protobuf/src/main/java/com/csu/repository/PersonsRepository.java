package com.csu.repository;

import com.csu.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonsRepository extends JpaRepository<Person, String> {
}
