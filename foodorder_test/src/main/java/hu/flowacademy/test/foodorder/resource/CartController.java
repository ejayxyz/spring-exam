package hu.flowacademy.test.foodorder.resource;

import hu.flowacademy.test.foodorder.model.Cart;
import hu.flowacademy.test.foodorder.repository.CartRepository;
import hu.flowacademy.test.foodorder.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartService cartService;

    @GetMapping("/{id}")
    public Optional<Cart> findCartById(@PathVariable Long id){
        return cartService.findById(id);
    }

    @GetMapping("/{username}")
    public List<Cart> findCartsByUsername(@PathVariable String username){
        return cartService.findByUsername(username);
    }

    @PostMapping("")
    public Cart createCart(@RequestBody Cart cart){
        return cartService.save(cart);
    }

}
