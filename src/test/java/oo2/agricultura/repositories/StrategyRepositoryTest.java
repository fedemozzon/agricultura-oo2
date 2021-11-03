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
    private StrategyRepository strategyRepository;

    @Test
    void createRecipeStrategy() {
        RecipeStrategy recipeStrategy = new RecipeStrategy();
        strategyRepository.save(recipeStrategy);
        Optional<RecipeStrategy> recipeStrategyPersist = strategyRepository.findById(recipeStrategy.getId());
        Assertions.assertEquals(2,recipeStrategyPersist.get().suggestions().size());
    }
    @Test
    void createInfoStrategy() {
        InfoStrategy recipeStrategy = new InfoStrategy();
        strategyRepository.save(recipeStrategy);
        Optional<InfoStrategy> recipeStrategyPersist = strategyRepository.findById(recipeStrategy.getId());
        Assertions.assertEquals(2,recipeStrategyPersist.get().suggestions().size());
    }
    @Test
    void createMixStrategy() {
        MixStrategy recipeStrategy = new MixStrategy();
        strategyRepository.save(recipeStrategy);
        Optional<MixStrategy> recipeStrategyPersist = strategyRepository.findById(recipeStrategy.getId());
        Assertions.assertEquals(4,recipeStrategyPersist.get().suggestions().size());
    }
}
