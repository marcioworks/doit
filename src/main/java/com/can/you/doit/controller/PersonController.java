package com.can.you.doit.controller;

import com.can.you.doit.model.PersonEntity;
import com.can.you.doit.model.dto.PersonDTO;
import com.can.you.doit.service.PersonService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping()
    public ResponseEntity<List<PersonDTO>> getAllPerson() throws IOException {
        List<PersonDTO> persons =  personService.personList();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<PersonDTO> getPerson(@PathVariable Integer id) throws IOException {
        PersonDTO person =  personService.getPerson(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<PersonDTO> createPerson(@RequestBody PersonDTO personDTO) throws IOException {
        PersonDTO person =  personService.createPerson(personDTO);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
}
