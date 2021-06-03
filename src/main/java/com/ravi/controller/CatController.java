package com.ravi.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CatController
{

@Autowired
com.ravi.service.CatService catService;


@GetMapping("/user")
private List<com.ravi.model.User> getAllStudent()
{
return catService.getAllStudent();
}

@GetMapping("/user/{id}")
private com.ravi.model.User getStudent(@PathVariable("id") int id)
{
return catService.getStudentById(id);
}

@PostMapping("/user")
private int saveStudent(@RequestBody com.ravi.model.User user)
{
catService.saveOrUpdate(user);
return user.getId();
}

    @PostMapping("/user/{id}/cat")
    private int saveUserCat(@PathVariable("id") int id)
    {
        catService.saveUserCat(id);
        return id;
    }

    @GetMapping("/user/{id}/cat")
    private List<com.ravi.model.Cat> getUserCats(@PathVariable("id") int id)
    {
        return catService.getUserCats(id);

    }

}
