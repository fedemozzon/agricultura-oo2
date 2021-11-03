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
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void userWithStrategy() {
        RecipeStrategy recpStrat = new RecipeStrategy();
        User user1 = new User("genericUserName", "genericMail@gmail.com",recpStrat);
        userRepository.save(user1);
        Optional<User> recepPersist = userRepository.findById(user1.getId());
        Assertions.assertEquals("genericUserName",recepPersist.get().getUsername());
        Assertions.assertEquals("genericMail@gmail.com",recepPersist.get().getMail());
        Assertions.assertTrue(recepPersist.get().getStrategy() instanceof RecipeStrategy);
    }
    @Test
    void userChangeStrategyFromRecipeToInfo() {
        RecipeStrategy recpStrat = new RecipeStrategy();
        User user1 = new User("genericUserName", "genericMail@gmail.com",recpStrat);
        userRepository.save(user1);
        InfoStrategy infoStrat = new InfoStrategy();
        user1.setStrategy(infoStrat);
        userRepository.save(user1);
        Optional<User> recepPersist = userRepository.findById(user1.getId());
        Assertions.assertEquals("genericUserName",user1.get().getUsername());
        Assertions.assertEquals("genericMail@gmail.com",user1.get().getMail());
        Assertions.assertTrue(user1.get().getStrategy() instanceof InfoStrategy);
    }
    @Test
    void userChangeStrategyFromInfoToMix() {
        InfoStrategy infoStrat = new InfoStrategy();
        User user1 = new User("genericUserName", "genericMail@gmail.com",infoStrat);
        userRepository.save(user1);
        MixStrategy mixStrat = new MixStrategy();
        user1.setStrategy(mixStrat);
        userRepository.save(user1);
        Optional<User> recepPersist = userRepository.findById(user1.getId());
        Assertions.assertEquals("genericUserName",user1.get().getUsername());
        Assertions.assertEquals("genericMail@gmail.com",user1.get().getMail());
        Assertions.assertTrue(user1.get().getStrategy() instanceof MixStrategy);
    }
    @Test
    void userChangeStrategyFromMixToRecipe() {
        MixStrategy mixStrat = new MixStrategy();
        User user1 = new User("genericUserName", "genericMail@gmail.com",mixStrat);
        userRepository.save(user1);
        RecipeStrategy recipeStrat = new RecipeStrategy();
        user1.setStrategy(recipeStrat);
        userRepository.save(user1);
        Optional<User> recepPersist = userRepository.findById(user1.getId());
        Assertions.assertEquals("genericUserName",user1.get().getUsername());
        Assertions.assertEquals("genericMail@gmail.com",user1.get().getMail());
        Assertions.assertTrue(user1.get().getStrategy() instanceof RecipeStrategy);
    }
    @Test
    void userChangeStrategyFromMixToRecipe() {
        UserAnonim user1 = new UserAnonim();
        Assertions.assertTrue(user1.getStrategy() instanceof MixStrategy);
    }
}
