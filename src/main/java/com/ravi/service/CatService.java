package com.ravi.service;

import com.ravi.CatResponse;
import com.ravi.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//defining the business logic
@Service
public class CatService
{
@Autowired
com.ravi.repository.UserRepository userRepository;

@Autowired
    CatRepository catRepository;

@org.springframework.beans.factory.annotation.Value("${catURL}")
private  String catURL;

public List<com.ravi.model.User> getAllStudent()
{
List<com.ravi.model.User> users = new ArrayList<com.ravi.model.User>();
userRepository.findAll().forEach(student -> users.add(student));
return users;
}
//getting a specific record
public com.ravi.model.User getStudentById(int id)
{
return userRepository.findById(id).get();
}
public void saveOrUpdate(com.ravi.model.User student)
{
    com.ravi.model.User user = userRepository.findByName(student.getName());
    if(user!=null){
        throw new RuntimeException("user already exist");
    }
    userRepository.save(student);
}

    public String saveUserCat(int id) {

    Optional<com.ravi.model.User> savedUser = userRepository.findById(id);
    if(savedUser.isPresent()){
        RestTemplate restTemplate = new RestTemplate();
        CatResponse catResponse=restTemplate.getForObject(catURL, CatResponse.class);
        com.ravi.model.Cat cat = new com.ravi.model.Cat();
        cat.setUserId(id);
        cat.setUrl(catResponse.getUrl());
        catRepository.save(cat);
        return "success";
    }else{
        return "Invalid user.";
    }

    }

    public List<com.ravi.model.Cat> getUserCats(int id) {
    return catRepository.findByUserId(id);
    }
}