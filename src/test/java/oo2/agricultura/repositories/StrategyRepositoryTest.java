package oo2.agricultura.repositories;

import oo2.agricultura.model.Recipe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StrategyRepositoryTest {

    @Autowired
    private RecipeRepository recipeRepository;

    @Test
    void createRecipeStrategy() {
        RecipeStrategy recipeStrategy = new RecipeStrategy();
        recipeRepository.save(recipeStrategy);
        Optional<RecipeStrategy> recipeStrategyPersist = recipeRepository.findById(recipeStrategy.getId());
        Assertions.assertEquals(2,recipeStrategyPersist.get().suggestions().size());
    }
    @Test
    void createInfoStrategy() {
        InfoStrategy recipeStrategy = new InfoStrategy();
        recipeRepository.save(recipeStrategy);
        Optional<InfoStrategy> recipeStrategyPersist = recipeRepository.findById(recipeStrategy.getId());
        Assertions.assertEquals(2,recipeStrategyPersist.get().suggestions().size());
    }
    @Test
    void createMixStrategy() {
        MixStrategy recipeStrategy = new MixStrategy();
        recipeRepository.save(recipeStrategy);
        Optional<MixStrategy> recipeStrategyPersist = recipeRepository.findById(recipeStrategy.getId());
        Assertions.assertEquals(4,recipeStrategyPersist.get().suggestions().size());
    }
}
