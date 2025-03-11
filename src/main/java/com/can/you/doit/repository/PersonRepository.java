package com.can.you.doit.repository;

import com.can.you.doit.model.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity,Integer> {
}
