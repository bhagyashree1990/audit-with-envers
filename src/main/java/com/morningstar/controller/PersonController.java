package com.morningstar.controller;

import com.morningstar.entity.Person;
import com.morningstar.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {
    private final PersonRepository personRepository;

    @GetMapping
    public Page<Person> getPersons(Pageable pageable) {
        return personRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Person findPerson(@PathVariable Integer id) {
        return personRepository.findById(id).get();
    }

    @PostMapping
    public Person savePerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @PutMapping("/{id}/{age}")
    @Transactional
    public Person updatePerson(@PathVariable Integer id, @PathVariable Integer age) {
        Person person = personRepository.getById(id);
        person.setAge(age);
        return personRepository.save(person);
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable Integer id) {
        personRepository.deleteById(id);
        return "Deleted person";
    }

    @GetMapping("/{id}/revision")
    public List<Person> findPersonRevision(@PathVariable Integer id) {
        return personRepository.findRevisions(id).get().map(revision -> revision.getEntity()).collect(Collectors.toList());
    }

    @GetMapping("/{id}/revision/latest")
    public Person findPersonRevisionLatest(@PathVariable Integer id) {
        return personRepository.findLastChangeRevision(id).get().getEntity();
    }

}
