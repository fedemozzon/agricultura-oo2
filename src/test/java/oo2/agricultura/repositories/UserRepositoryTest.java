package oo2.agricultura.repositories;


import oo2.agricultura.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@Rollback(value = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {

    @Autowired
    private LoginUserRepository userRepository;
    @Autowired
    private StrategyRepository strategyRepository;

    @Test
    void userWithStrategy() {
        intializeStategies();
        Optional<Strategy> recpStrat = strategyRepository.findById(new Long(2));
        LoginUser user1 = new LoginUser("genericUserName", "genericMail@gmail.com",recpStrat.get());
        userRepository.save(user1);
        Optional<LoginUser> recepPersist = userRepository.findById(user1.getId());
        Strategy strat = recepPersist.get().getStrategy();
        Assertions.assertEquals("genericUserName",recepPersist.get().getUsername());
        Assertions.assertEquals("genericMail@gmail.com",recepPersist.get().getMail());
        Assertions.assertTrue(strat instanceof RecipeStrategy);
    }
    @Test
    void userChangeStrategyFromRecipeToInfo() {
        intializeStategies();
        Optional<Strategy> recpStrat = strategyRepository.findById(new Long(2));
        LoginUser user1 = new LoginUser("genericUserName", "genericMail@gmail.com",recpStrat.get());
        userRepository.save(user1);
        Optional<Strategy> infoStrat = strategyRepository.findById(new Long(3));
        user1.setStrategy(infoStrat.get());
        userRepository.save(user1);
        Optional<LoginUser> recepPersist = userRepository.findById(user1.getId());
        Strategy strat = recepPersist.get().getStrategy();
        Assertions.assertEquals("genericUserName",user1.getUsername());
        Assertions.assertEquals("genericMail@gmail.com",user1.getMail());
        Assertions.assertTrue(strat instanceof InfoStrategy);
    }
    @Test
    void userChangeStrategyFromInfoToMix() {
        intializeStategies();
        Optional<Strategy> infoStrat = strategyRepository.findById(new Long(3));
        LoginUser user1 = new LoginUser("genericUserName", "genericMail@gmail.com",infoStrat.get());
        userRepository.save(user1);
        Optional<Strategy> mixStrat = strategyRepository.findById(new Long(1));
        user1.setStrategy(mixStrat.get());
        userRepository.save(user1);
        Optional<LoginUser> recepPersist = userRepository.findById(user1.getId());
        Strategy strat = recepPersist.get().getStrategy();
        Assertions.assertEquals("genericUserName",user1.getUsername());
        Assertions.assertEquals("genericMail@gmail.com",user1.getMail());
        Assertions.assertTrue(strat instanceof MixStrategy);
    }
    @Test
    void userChangeStrategyFromMixToRecipe() {
        intializeStategies();
        Optional<Strategy> mixStrat = strategyRepository.findById(new Long(1));
        LoginUser user1 = new LoginUser("genericUserName", "genericMail@gmail.com",mixStrat.get());
        userRepository.save(user1);
        Optional<Strategy> recipeStrat = strategyRepository.findById(new Long(2));
        user1.setStrategy(recipeStrat.get());
        userRepository.save(user1);
        Optional<LoginUser> recepPersist = userRepository.findById(user1.getId());
        Strategy strat = recepPersist.get().getStrategy();
        Assertions.assertEquals("genericUserName",user1.getUsername());
        Assertions.assertEquals("genericMail@gmail.com",user1.getMail());
        Assertions.assertTrue(strat instanceof RecipeStrategy);
    }

    private void intializeStategies(){
        int num = strategyRepository.findAll().size();
        if (strategyRepository.findAll().size() == 0) {
            RecipeStrategy recipeStrategy = new RecipeStrategy("Recipes");
            MixStrategy mixStrategy = new MixStrategy("Mix");
            InfoStrategy infoStrategy = new InfoStrategy("Information");
            strategyRepository.save(mixStrategy);
            strategyRepository.save(recipeStrategy);
            strategyRepository.save(infoStrategy);
        }
    }
}
