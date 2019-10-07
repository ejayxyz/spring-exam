package hu.flowacademy.test.foodorder.services;

import hu.flowacademy.test.foodorder.model.User;
import hu.flowacademy.test.foodorder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public User update(User user) {
        var newUser = userRepository.findByUsername(user.getUsername());
        newUser.setAddress(user.getAddress());
        newUser.setFullname(user.getFullname());
        return newUser;
    }
}
