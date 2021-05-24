package com.lafiray.springboot.dao;

import com.lafiray.springboot.enteties.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserDAO extends CrudRepository<Person, UUID> {
}
