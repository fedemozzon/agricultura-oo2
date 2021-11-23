package oo2.agricultura.controller;

import oo2.agricultura.model.Ingredient;
import oo2.agricultura.model.Recipe;
import oo2.agricultura.model.Vegetal;
import oo2.agricultura.repositories.IngredientRepository;
import oo2.agricultura.repositories.RecipeRepository;
import oo2.agricultura.repositories.VegetalRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class IngredientController {
    private final VegetalRepository vegetalRepository;
    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;

    IngredientController(VegetalRepository vegetalRepository, RecipeRepository recipeRepository, IngredientRepository ingredientRepository){
        this.vegetalRepository = vegetalRepository;
        this.recipeRepository= recipeRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping("/vegetals/{id}")
    Optional<Vegetal> one(@PathVariable Long id) {
        return vegetalRepository.findById(id);
    }

    @GetMapping("/vegetals")
    List<Vegetal> all() { return vegetalRepository.findAll();}

    @GetMapping("/recipes/{id}")
    Optional<Recipe> oneRecipe(@PathVariable Long id) {
        return recipeRepository.findById(id);
    }

    @GetMapping("/recipes")
    List<Recipe> allRecipe() { return recipeRepository.findAll();}

    /** Este habria que mandarle una lista de enteros que son el id de las recetas e ingredientes **/
    @PostMapping("/recipes")
    Recipe newRecipe(@RequestBody Recipe newRecipe) {
        List<Ingredient> ingredients = new ArrayList<>(newRecipe.getIngredients());
        newRecipe.cleanIngredients();
        ingredients.stream().forEach((elem) -> {
            Optional<Ingredient> ingAux = ingredientRepository.findById(elem.getId());
            ingAux.ifPresent(veg -> newRecipe.addIngredient(veg));
        });
        return recipeRepository.save(newRecipe);}

    @PostMapping("/vegetals")
    Vegetal newVegetal(@RequestBody Vegetal newVegetal) { return vegetalRepository.save(newVegetal);}
}
