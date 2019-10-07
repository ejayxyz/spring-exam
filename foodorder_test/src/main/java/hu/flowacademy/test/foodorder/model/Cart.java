package hu.flowacademy.test.foodorder.model;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column
    private LocalDateTime orderDate;

    @OrderColumn
    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "food_id"),
            inverseJoinColumns = @JoinColumn(name = "cart_id"))
    private Food[] foods;

    Cart() {
    }

    public Cart(User user, Food[] foods) {
        this.user = user;
        this.orderDate = LocalDateTime.now();
        this.foods = foods;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Food[] getFoods() {
        return foods;
    }

    public void setFoods(Food[] foods) {
        this.foods = foods;
    }
}
