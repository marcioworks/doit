package com.can.you.doit.service;

import com.can.you.doit.model.PersonEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

public interface PersonService {

    List<PersonEntity> personList() throws IOException;
}
