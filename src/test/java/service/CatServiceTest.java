package service;

import com.ravi.model.Cat;
import com.ravi.model.User;
import com.ravi.repository.CatRepository;
import com.ravi.repository.UserRepository;
import com.ravi.service.CatService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
public class CatServiceTest {

    @Mock
    UserRepository userRepository;

    @Mock
    CatRepository catRepository;

    @InjectMocks
    CatService catService;

    @Test
    public void getAllStudent(){
        List<User> users = new ArrayList<>();
        Mockito.when(userRepository.findAll()).thenReturn(users);
        Assert.assertNotNull(catService.getAllStudent());
    }

    @Test
    public void getStudentById(){
        List<User> users = new ArrayList<>();
        User user = new User();
        Optional<User> useroptions = Optional.of(user);
        Mockito.when(userRepository.findById(1)).thenReturn(useroptions);
        Assert.assertNotNull(catService.getStudentById(1));
    }

    @Test(expected = RuntimeException.class)
    public void saveOrUpdateException(){
        User user = new User();
        user.setName("test");
        Mockito.when(userRepository.findByName("test")).thenReturn(user);
        catService.saveOrUpdate(user);
    }
    @Test()
    public void saveOrUpdate(){
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setName("test");
        Mockito.when(userRepository.findByName("test")).thenReturn(null);
        Mockito.when(userRepository.save(user)).thenReturn(user);
        catService.saveOrUpdate(user);
    }
   @Test
    public void getUserCats(){
        List<Cat> cats = new ArrayList<>();
        Mockito.when(catRepository.findByUserId(1)).thenReturn(cats);
       Assert.assertNotNull(catService.getUserCats(1));
   }
}
