package oo2.agricultura.model;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
public class Recipe  extends  Ingredient{

    @OneToMany
    private List<Ingredient> ingredients;

    public Recipe(String name, List<Ingredient> ingredients) {
        super(name);
        this.ingredients = ingredients;
    }

    public Recipe() {

    }
    public void addIngredient(Ingredient ingredient){
        this.ingredients.add(ingredient);
    }
    public void cleanIngredients(){
        ingredients.clear();
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

}