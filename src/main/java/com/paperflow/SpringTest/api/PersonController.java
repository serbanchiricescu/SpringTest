package com.paperflow.SpringTest.api;

import com.paperflow.SpringTest.model.Person;
import com.paperflow.SpringTest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    @GetMapping(path = "/{id}")
    public Person getPersonById(@PathVariable("id") UUID id) {
        return personService.selectPersonById(id).orElse(null);
    }

    @PutMapping(path = "/{id}")
    public void updatePersonById(@PathVariable("id") UUID id,
                                 @RequestBody Person person) {
        personService.updatePersonById(id, person);
    }

    @DeleteMapping(path = "/{id}")
    public void deletePersonById(@PathVariable("id")UUID id) {
        personService.deletePersonById(id);
    }

}
