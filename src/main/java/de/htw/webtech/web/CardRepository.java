package de.htw.webtech.web;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CardRepository extends CrudRepository<Card, Long> {

}
