package hu.flowacademy.test.foodorder.config;

import hu.flowacademy.test.foodorder.model.Food;
import hu.flowacademy.test.foodorder.model.User;
import hu.flowacademy.test.foodorder.repository.FoodRepository;
import hu.flowacademy.test.foodorder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class InitDataLoader implements CommandLineRunner {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
        foodRepository.save(new Food("saláta", "répa, karfiol"));
        foodRepository.save(new Food("pizza", "szalámi, paradicsom"));
        foodRepository.save(new Food("gyros", "feta, tzatziki"));
        foodRepository.save(new Food("marhapörkölt", "robi kedvence"));
        foodRepository.save(new Food("fering", "halféle"));
    }
}
