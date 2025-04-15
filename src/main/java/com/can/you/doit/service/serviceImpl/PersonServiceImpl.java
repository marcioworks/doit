package com.can.you.doit.service.serviceImpl;

import com.can.you.doit.model.PersonEntity;
import com.can.you.doit.model.dto.CreatePersonDTO;
import com.can.you.doit.model.dto.PersonDTO;
import com.can.you.doit.repository.PersonRepository;
import com.can.you.doit.service.PersonService;
import com.can.you.doit.utils.GenericModelMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final GenericModelMapper modelMapper;

    public PersonServiceImpl(PersonRepository personRepository, GenericModelMapper modelMapper, GenericModelMapper modelMapper1) {
        this.personRepository = personRepository;
        this.modelMapper = modelMapper1;
    }

    @Override
    public List<PersonDTO> personList() throws IOException {
        List<PersonEntity> personList = personRepository.findAll();
        return modelMapper.mapList(personList,PersonDTO.class);
    }

    @Override
    public PersonDTO getPerson(Integer id) throws IOException {
        Optional<PersonEntity> person = personRepository.findById(id);
        return  toDTO(person.get());
    }

    @Override
    public PersonDTO createPerson(CreatePersonDTO personDTO) {
      PersonEntity person = modelMapper.map(personDTO, PersonEntity.class);
       person = personRepository.save(person);
       return modelMapper.map(person,PersonDTO.class);
    }

    private List<PersonDTO> entityListToDTO(List<PersonEntity> personList) {
     return  personList.stream()
                .map(this::toDTO)
                .toList();
    }

    private PersonDTO toDTO(PersonEntity person) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(person.getId());
        personDTO.setName(person.getName());
        personDTO.setAge(person.getAge());
        personDTO.setBloodType(person.getBloodType());
        personDTO.setSugarLevel(person.getSugarLevel());
        personDTO.setBloodPressure(person.getBloodPressure());
        personDTO.setCholesterolLevel(person.getCholesterolLevel());
        personDTO.setWeight(person.getWeight());
        personDTO.setHeight(person.getHeight());
        personDTO.setHeartRate(person.getHeartRate());
        personDTO.setExerciseLevel(person.getExerciseLevel());
        personDTO.setSleepHours(person.getSleepHours());
        personDTO.setSmokingStatus(person.getSmokingStatus());
        personDTO.setAlcoholConsumption(person.getAlcoholConsumption());
        personDTO.setSleepHours(person.getSleepHours());
        personDTO.setSleepHours(person.getSleepHours());
        List<String> medications = new ArrayList<>();
        for(String med: person.getMedications()){
            medications.add(med);
        }
        personDTO.setMedications(medications);
        List<String> alergies = new ArrayList<>();
        for (String aler: person.getAllergies()){
            alergies.add(aler);
        }
        personDTO.setAllergies(alergies);
        List<String> family = new ArrayList<>();
        for(String fam: person.getFamilyHistory()){
            family.add(fam);
        }
        personDTO.setFamilyHistory(family);
        return  personDTO;
    }
}
