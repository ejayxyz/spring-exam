package hu.flowacademy.test.foodorder.services;

import hu.flowacademy.test.foodorder.exception.ValidationException;
import hu.flowacademy.test.foodorder.model.Cart;
import hu.flowacademy.test.foodorder.repository.CartRepository;
import hu.flowacademy.test.foodorder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;


    public List<Cart> findByUsername(String username) {
        var user = userRepository.findByUsername(username);
        return cartRepository.findByUser(user);
    }

    public Cart save(Cart cart) {
        if(cart.getFoods() ==  null || cart.getUser().getUsername() ==  null){
            throw new ValidationException("Felhasználó és étel is szükséges kosár létrehozásához");
        } else {
            return cartRepository.save(cart);
        }
    }

    public Optional<Cart> findById(Long id) {
        return cartRepository.findById(id);
    }
}
