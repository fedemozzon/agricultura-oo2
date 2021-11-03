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
    private RecipeRepository userRepository;

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
}
