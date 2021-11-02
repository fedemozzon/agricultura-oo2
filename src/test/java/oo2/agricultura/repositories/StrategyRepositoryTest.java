package oo2.agricultura.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StrategyRepositoryTest {

    @Autowired
    private RecipeRepository recipeRepository;

    @Test
    void createRecipeStrategy() {
    }
    @Test
    void createInfoStrategy() {
    }
    @Test
    void createMixStrategy() {
    }
}
