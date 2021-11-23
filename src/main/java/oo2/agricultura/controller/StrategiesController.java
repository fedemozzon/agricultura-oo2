package oo2.agricultura.controller;

import oo2.agricultura.model.*;
import oo2.agricultura.repositories.StrategyRepository;
import org.springframework.web.bind.annotation.*;


@RestController
public class StrategiesController {

    private final StrategyRepository strategyRepository;

    public StrategiesController(StrategyRepository strategyRepository) {
        this.strategyRepository = strategyRepository;
    }


    @PostMapping("/strategies/initialize")
    void initializeStrategies() {
        RecipeStrategy recipeStrategy  = new RecipeStrategy("Recipes");
        MixStrategy mixStrategy = new MixStrategy("Mix");
        InfoStrategy infoStrategy = new InfoStrategy("Information");
        strategyRepository.save(mixStrategy);
        strategyRepository.save(recipeStrategy);
        strategyRepository.save(infoStrategy);
    }

}

