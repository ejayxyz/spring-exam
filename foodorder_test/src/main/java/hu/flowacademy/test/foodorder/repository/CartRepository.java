package hu.flowacademy.test.foodorder.repository;

import hu.flowacademy.test.foodorder.model.Cart;
import hu.flowacademy.test.foodorder.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findByUser(User user);
}
