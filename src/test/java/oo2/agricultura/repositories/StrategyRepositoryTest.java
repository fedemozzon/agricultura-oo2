package oo2.agricultura.repositories;

import oo2.agricultura.model.*;
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
class StrategyRepositoryTest {
    @Autowired
    private VegetalRepository vegetalRepository;
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private  StrategyRepository strategyRepository;



    @Test
    void createRecipeStrategy() {
        Vegetal veg1 = new Vegetal("Nabo","Buena para algo","link");
        Vegetal veg2 = new Vegetal("Zanahoria","Buena para la vista","link");
        Vegetal veg3 = new Vegetal("Papa","Alto en almidon","link");
        RecipeStrategy recipeStrategy = new RecipeStrategy("Recipes");
        strategyRepository.save(recipeStrategy);
        vegetalRepository.save(veg1);
        vegetalRepository.save(veg2);
        vegetalRepository.save(veg3);
        List<Ingredient> ings = new ArrayList();
        ings.add(veg1);ings.add(veg2);ings.add(veg3);
        Recipe recipe1 = new Recipe("Sopa",ings);
        recipeRepository.save(recipe1);
        Optional<Strategy> recipeStrategyPersist = strategyRepository.findById(recipeStrategy.getId());
        recipeStrategyPersist.get().addSuggestion(vegetalRepository.findAll(),recipeRepository.findAll());
        List<Object> on = recipeStrategyPersist.get().getSuggestions();
        Assertions.assertEquals(1,recipeStrategyPersist.get().getSuggestions().size());
    }
    @Test
    void createInfoStrategy() {
        Vegetal veg1 = new Vegetal("Nabo","Buena para algo","link");
        Vegetal veg2 = new Vegetal("Zanahoria","Buena para la vista","link");
        Vegetal veg3 = new Vegetal("Papa","Alto en almidon","link");
        InfoStrategy infoStrategy = new InfoStrategy("Information");
        strategyRepository.save(infoStrategy);
        vegetalRepository.save(veg1);
        vegetalRepository.save(veg2);
        vegetalRepository.save(veg3);
        Optional<Strategy> recipeStrategy = strategyRepository.findById(infoStrategy.getId());
        recipeStrategy.get().addSuggestion(vegetalRepository.findAll(),recipeRepository.findAll());
        Assertions.assertEquals(3,recipeStrategy.get().getSuggestions().size());
    }
    @Test
    void createMixStrategy() {
        Vegetal veg1 = new Vegetal("Nabo","Buena para algo","link");
        Vegetal veg2 = new Vegetal("Zanahoria","Buena para la vista","link");
        Vegetal veg3 = new Vegetal("Papa","Alto en almidon","link");
        MixStrategy mixStrategy = new MixStrategy("Mix");
        strategyRepository.save(mixStrategy);
        vegetalRepository.save(veg1);
        vegetalRepository.save(veg2);
        vegetalRepository.save(veg3);
        List<Ingredient> ings = new ArrayList();
        ings.add(veg1);ings.add(veg2);ings.add(veg3);
        Recipe recipe1 = new Recipe("Sopa",ings);
        recipeRepository.save(recipe1);
        Optional<Strategy> recipeStrategy = strategyRepository.findById(mixStrategy.getId());
        recipeStrategy.get().addSuggestion(vegetalRepository.findAll(),recipeRepository.findAll());
        Assertions.assertEquals(4,recipeStrategy.get().getSuggestions().size());
    }
}
