package hu.flowacademy.test.foodorder.model;

import javax.persistence.*;

@Entity
@Table
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column
    private String name;

    @Column
    private String parts;

    @OrderColumn
    @ManyToMany(mappedBy = "foods")
    private Cart[] carts;

    Food(){
    }

    public Food(String name, String parts) {
        this.name = name;
        this.parts = parts;
    }

    public Food(String name, String parts, Cart[] carts) {
        this.name = name;
        this.parts = parts;
        this.carts = carts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParts() {
        return parts;
    }

    public void setParts(String parts) {
        this.parts = parts;
    }

    public Cart[] getCarts() {
        return carts;
    }

    public void setCarts(Cart[] carts) {
        this.carts = carts;
    }
}
