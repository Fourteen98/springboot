package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.dao.PersonDao;
import com.example.demo.model.PersonForJpa;
import com.example.demo.pojo.PersonResponse;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonDao personDao;
    private final PersonRepository personRepo;

    @Autowired
    public PersonService(@Qualifier("postgres") PersonDao personDao, PersonRepository personRepo) {
        this.personDao = personDao;
        this.personRepo = personRepo;
    }

    public  int addPerson(Person person){
        return personDao.insertPerson(person);
    }

    public PersonForJpa savePerson(PersonForJpa person){
        return personRepo.save(person);
    }

    public PersonResponse processPersonResponse(PersonForJpa person){
        return PersonResponse.builder().name(person.getName()).age(person.getAge()).build();
    }

    public List<Person> getAllPeople(){
        return personDao.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id){
        return personDao.selectPersonById(id);
    }

    public int deletePerson(UUID id){
        return personDao.deletePersonById(id);
    }

    public int updatePerson(UUID id, Person newPerson){
        return personDao.updatePersonById(id, newPerson);
    }

    public PersonResponse findByName(String name){
        return processPersonResponse(personRepo.findByName(name).orElseThrow(() -> new RuntimeException("Person not found")));
    }
}
