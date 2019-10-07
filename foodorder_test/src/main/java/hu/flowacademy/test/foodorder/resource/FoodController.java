package hu.flowacademy.test.foodorder.resource;

import hu.flowacademy.test.foodorder.model.Food;
import hu.flowacademy.test.foodorder.repository.FoodRepository;
import hu.flowacademy.test.foodorder.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private FoodService foodService;

    @GetMapping("/{foodname}")
    public Food findOne(@PathVariable String foodname){
        return foodService.findOne(foodname);
    }

    @GetMapping("")
    public List<Food> findAll(){
        return foodService.findAll();
    }

    @PostMapping("")
    public Food createFood(@RequestBody Food food){
        return foodService.save(food);
    }

    @PutMapping("")
    public Food updateFood(@RequestBody Food food){
        return foodService.update(food);
    }

    @DeleteMapping("")
    public void deleteFood(@RequestBody Food food){
        foodService.delete(food);
    }
}
