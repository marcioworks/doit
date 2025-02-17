package com.can.you.doit.controller;

import com.can.you.doit.model.PersonEntity;
import com.can.you.doit.service.PersonService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<List<PersonEntity>> getAllPerson() throws IOException {
        List<PersonEntity> persons =  personService.personList();

        return new ResponseEntity<>(persons, HttpStatus.OK);
    }
}
