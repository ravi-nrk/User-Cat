package com.ravi.repository;
import org.springframework.data.repository.CrudRepository;
public interface UserRepository extends CrudRepository<com.ravi.model.User, Integer>
{
    com.ravi.model.User findByName(String name);
}
