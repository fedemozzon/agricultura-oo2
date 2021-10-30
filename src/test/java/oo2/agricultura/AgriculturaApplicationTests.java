package oo2.agricultura;

import oo2.agricultura.model.Ingredient;
import oo2.agricultura.model.Recipe;
import oo2.agricultura.model.Vegetables;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AgriculturaApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void creationTest() {
        Vegetables ing1  = new Vegetables("Zanahoria", "Es buena para la vista y el corazon");
        Vegetables ing2  = new Vegetables("Papa", "Algo bueno debe tener");
        List<Ingredient> ingredients = null ;
        ingredients.add(ing1);ingredients.add(ing2);
        Recipe recipe1 = new Recipe(ingredients);

    }

}
