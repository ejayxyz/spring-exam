package hu.flowacademy.test.foodorder.resource;


import hu.flowacademy.test.foodorder.model.User;
import hu.flowacademy.test.foodorder.repository.UserRepository;
import hu.flowacademy.test.foodorder.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/{username}")
    public User findOne(@PathVariable String username){
        return userService.findByUsername(username);
    }

    @GetMapping("")
    public List<User> findAll(){
        return userService.findAll();
    }

    @PostMapping("")
    public User createUser(@RequestBody User user){
        return userService.save(user);
    }

    @PutMapping("")
    public User updateUser(@RequestBody User user){
        return userService.update(user);
    }

    @DeleteMapping("")
    public void deleteUser(@RequestBody User user){
        userService.delete(user);
    }
}
