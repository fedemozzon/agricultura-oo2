package oo2.agricultura.model;

import javax.persistence.*;


import java.util.List;
 @Table(name = "Ingredients")
@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ingredient() {

    }

     public String getName() {
         return name;
     }

     public Ingredient(String name) {
        this.name = name;
    }
}
