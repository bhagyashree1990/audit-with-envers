package com.morningstar.repository;

import com.morningstar.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer>, RevisionRepository<Person,Integer,Integer> {
}
