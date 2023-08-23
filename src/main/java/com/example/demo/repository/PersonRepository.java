package com.example.demo.repository;

import com.example.demo.model.PersonForJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<PersonForJpa, UUID> {

     Optional<PersonForJpa> findByName(String name);

}
