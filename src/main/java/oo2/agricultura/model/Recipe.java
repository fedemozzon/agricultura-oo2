package oo2.agricultura.model;

import javax.persistence.*;
import java.util.List;

@Table(name = "recipe")
@Entity
public class Recipe  extends  Ingredient{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @OneToMany
    private List<Ingredient> ingredientes;
    public Recipe(List ing) {
        this.ingredientes = ing;
    }

    public Recipe() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}