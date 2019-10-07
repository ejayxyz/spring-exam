package hu.flowacademy.test.foodorder.services;

import hu.flowacademy.test.foodorder.exception.ValidationException;
import hu.flowacademy.test.foodorder.model.Food;
import hu.flowacademy.test.foodorder.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;


    public Food findOne(String foodname) {
        return foodRepository.findByName(foodname);
    }

    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    public Food save(Food food) {
        if(food.getName() == null || food.getParts() == null){
            throw new ValidationException("Szükséges az étel neve, és hozzávalói");
        } else {
            return foodRepository.save(food);
        }
    }

    public Food update(Food food) {
        var newFood = foodRepository.findByName(food.getName());
        newFood.setName(food.getName());
        newFood.setParts(food.getParts());
        newFood.setCarts(food.getCarts());
        return newFood;
    }

    public void delete(Food food) {
        foodRepository.delete(food);
    }
}
