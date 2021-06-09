package com.ravi.controller;

import com.ravi.model.Cat;
import com.ravi.model.User;
import com.ravi.service.CatService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@org.junit.runner.RunWith(SpringJUnit4ClassRunner.class)
@PrepareForTest
public class CatControllerTest {

    @Mock
    CatService catService;

    @org.mockito.InjectMocks
    private CatController catController;



    @Test
    public void testGetUsers(){
        List<User> users = new ArrayList<>();
        User user = new User();users.add(user);
        Mockito.when(catService.getAllStudent()).thenReturn(users);
        Assert.assertNotNull(catController.getUsers());
    }
    @Test
    public void testGetUser(){

        User user = new User();
        Mockito.when(catService.getStudentById(1)).thenReturn(user);
        Assert.assertNotNull(catController.getUser(1));
    }

    @Test
    public void testSaveUser(){

        User user = new User();
        Mockito.doNothing().when(catService).saveOrUpdate(user);
        Assert.assertNotNull(catController.saveUser(user));
    }

    @Test
    public void saveUserCat(){
        Mockito.when(catService.saveUserCat(1)).thenReturn("Success");
        Assert.assertNotNull(catController.saveUserCat(1));
    }
    @Test
    public void getUserCats(){
        List<Cat> cats = new ArrayList<>();
        Mockito.when(catService.getUserCats(1)).thenReturn(cats);
        Assert.assertNotNull(catController.getUserCats(1));
    }
}
