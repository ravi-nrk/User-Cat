package com.ravi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CatController
{

@Autowired
com.ravi.service.CatService catService;


@GetMapping("/user")
public List<com.ravi.model.User> getUsers()
{
return catService.getAllStudent();
}

@GetMapping("/user/{id}")
public com.ravi.model.User getUser(@PathVariable("id") int id)
{
return catService.getStudentById(id);
}

@PostMapping("/user")
public int saveUser(@RequestBody com.ravi.model.User user)
{
catService.saveOrUpdate(user);
return user.getId();
}

    @PostMapping("/user/{id}/cat")
    public int saveUserCat(@PathVariable("id") int id)
    {
        catService.saveUserCat(id);
        return id;
    }

    @GetMapping("/user/{id}/cat")
    public List<com.ravi.model.Cat> getUserCats(@PathVariable("id") int id)
    {
        return catService.getUserCats(id);

    }

}
