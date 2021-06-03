package com.ravi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatRepository extends CrudRepository<com.ravi.model.Cat, Integer> {
    List<com.ravi.model.Cat> findByUserId(int id);
}
