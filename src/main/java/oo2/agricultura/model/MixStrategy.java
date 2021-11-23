package oo2.agricultura.model;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MixStrategy extends Strategy{
    public MixStrategy(String name) {
        super(name);
    }

    public MixStrategy() {

    }

    @Override
    public List<Object> getSuggestions() {
        setSuggestions(new ArrayList<>());
        getSuggestionsRecipe().stream().forEach(elem -> this.addSuggestions(elem));
        getSuggestionsVegetals().stream().forEach(elem -> this.addSuggestions(elem));
        return getSuggestion();
    }

    @Override
    public void addSuggestion(List<Vegetal> suggestionsVegetal, List<Recipe> suggestionsRecipe) {
        setSuggestionsRecipe(suggestionsRecipe);
        setSuggestionsVegetals(suggestionsVegetal);
    }
}