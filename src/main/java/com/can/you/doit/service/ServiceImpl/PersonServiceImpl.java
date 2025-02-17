package com.can.you.doit.service.ServiceImpl;

import com.can.you.doit.model.PersonEntity;
import com.can.you.doit.service.PersonService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
@Slf4j
public class PersonServiceImpl implements PersonService {
    @Override
    public List<PersonEntity> personList() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String filePath = "src/main/java/com/can/you/doit/mock/mock-person.json";

        System.out.println(new String(Files.readAllBytes(Paths.get(filePath))));
        List<PersonEntity> persons = objectMapper.readValue(new File(filePath), new TypeReference<List<PersonEntity>>() {});

        return persons;
    }
}
