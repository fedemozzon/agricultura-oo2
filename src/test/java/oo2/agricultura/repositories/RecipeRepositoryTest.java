package oo2.agricultura.repositories;

import oo2.agricultura.model.Recipe;
import oo2.agricultura.model.Vegetal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class RecipeRepositoryTest {

    @Autowired
    private RecipeRepository recipeRepository;

    @Test
    void recipeWithIngredients() {
        Vegetal veg1 = new Vegetal("Lechuga","Hace bien a la digestion","https://es.wikipedia.org/wiki/Lactuca_sativa");
        Vegetal veg2 = new Vegetal("Zanahoria","Buena para la vista","https://es.wikipedia.org/wiki/Daucus_carota");
        List ingredients = new ArrayList();
        ingredients.add(veg1);
        ingredients.add(veg2);
        Recipe recipe = new Recipe("Ensalada",ingredients);
        recipeRepository.save(recipe);
        Optional<Recipe> recepPersist = recipeRepository.findById(recipe.getId());
        Assertions.assertEquals("Ensalada",recepPersist.get().getName());
        Assertions.assertEquals(2,recepPersist.get().getIngredients().size());
    }
    @Test
    void recipeWithIngredientsAndOtherRecipe() {
        Vegetal veg1 = new Vegetal("Lechuga","Hace bien a la digestion","https://es.wikipedia.org/wiki/Lactuca_sativa");
        Vegetal veg2 = new Vegetal("Zanahoria","Buena para la vista","https://es.wikipedia.org/wiki/Daucus_carota");
        List ingredients = new ArrayList();
        ingredients.add(veg1);
        ingredients.add(veg2);
        Recipe recipe = new Recipe("Ensalada",ingredients);
        recipeRepository.save(recipe);
        Vegetal veg3 = new Vegetal("Berenjena","Hace bien a la digestion","https://es.wikipedia.org/wiki/Lactuca_sativa");
        List ingredients2 = new ArrayList();
        ingredients2.add(recipe);
        ingredients2.add(veg3);
        Recipe recipeWithRecipe = new Recipe("Berenjena con ensalada",ingredients2);
        recipeRepository.save(recipeWithRecipe);
        Optional<Recipe> recepPersist = recipeRepository.findById(recipeWithRecipe.getId());
        Assertions.assertEquals("Berenjena con ensalada",recepPersist.get().getName());
        Assertions.assertEquals(2,recepPersist.get().getIngredients().size());
    }
}