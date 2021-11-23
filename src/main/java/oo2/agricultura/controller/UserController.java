package oo2.agricultura.controller;

import oo2.agricultura.model.*;
import oo2.agricultura.repositories.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final LoginUserRepository userRepository;
    private final IngredientRepository ingredientRepository;
    private final VegetalRepository vegetalRepository;
    private final RecipeRepository recipeRepository;
    private final  StrategyRepository strategyRepository;

    UserController(LoginUserRepository loginUserRepository, IngredientRepository ingredientRepository, VegetalRepository vegetalRepository, RecipeRepository recipeRepository, StrategyRepository strategyRepository){
        this.userRepository = loginUserRepository;
        this.ingredientRepository = ingredientRepository;
        this.vegetalRepository = vegetalRepository;
        this.recipeRepository = recipeRepository;
        this.strategyRepository = strategyRepository;
    }

    @GetMapping("/users/{id}")
    Optional<LoginUser> one(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    @GetMapping("/users")
    List<LoginUser> all() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}/suggestions")
    List<Object> suggestions(@PathVariable Long id){
        LoginUser loginUser = userRepository.findById(id).get();
        loginUser.setStrategy(strategyRepository.findById(loginUser.getIdStrategy()).get());
        loginUser.getStrategy().addSuggestion(vegetalRepository.findAll(), recipeRepository.findAll());
        return loginUser.getStrategy().getSuggestions();
    }

    @PostMapping("/users")
    LoginUser newUser(@RequestBody LoginUser newUser) {
        Optional<Strategy> mixStrategy = strategyRepository.findById(new Long(1));
        newUser.setIdStrategy(new Long(1));
        newUser.setStrategy(mixStrategy.get());
        return userRepository.save(newUser);
    }
    @PutMapping("/users/{id}/strategy/recipes")
    LoginUser changeStrategyToRecipes(@PathVariable Long id) {
        LoginUser loginUser = userRepository.findById(id).get();
        return userRepository.save(changeStrategy(loginUser,strategyRepository.findById(new Long(2)).get(),new Long(2)));
    }

    @PutMapping("/users/{id}/strategy/information")
    LoginUser changeStrategyToInfo(@PathVariable Long id) {
        LoginUser loginUser = userRepository.findById(id).get();
        return userRepository.save(changeStrategy(loginUser,strategyRepository.findById(new Long(3)).get(),new Long(3)));
    }

    @PutMapping("/users/{id}/strategy/mix")
    LoginUser changeStrategyToMix(@PathVariable Long id) {
        LoginUser loginUser = userRepository.findById(id).get();
        return userRepository.save(changeStrategy(loginUser,strategyRepository.findById(new Long(1)).get(),new Long(1)));
    }

    private LoginUser changeStrategy(LoginUser loginUser, Strategy strategy,Long idStrategy){
        loginUser.setStrategy(strategy);
        loginUser.setIdStrategy(idStrategy);
        return loginUser;
    }
}