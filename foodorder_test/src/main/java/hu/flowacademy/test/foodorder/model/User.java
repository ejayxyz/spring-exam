package hu.flowacademy.test.foodorder.model;

import hu.flowacademy.test.foodorder.exception.ValidationException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class User {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private String username;

    @Column(nullable = false)
    private String fullname;

    @Column(nullable = false)
    private String address;

    @Column
    @OneToMany(mappedBy = "user")
    private List<Cart> cart;

    User(){
    }

    public User(String username, String fullname, String address) {
        if(username == null || fullname ==  null || address == null){
            throw new ValidationException("Minden mező kitöltése kötelező");
        } else {
            this.username = username;
            this.fullname = fullname;
            this.address = address;
            this.cart = new ArrayList<>();
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if(username == null){
            throw new ValidationException("Nincs username");
        }
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        if(fullname == null){
            throw new ValidationException("Nincs fullname");
        }
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if(address == null){
            throw new ValidationException("Nincs address");
        }
        this.address = address;
    }

    public List<Cart> getCart() {
        return cart;
    }

    public void setCart(List<Cart> cart) {
        this.cart = cart;
    }
}
