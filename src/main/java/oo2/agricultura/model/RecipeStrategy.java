package oo2.agricultura.model;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RecipeStrategy extends Strategy{

    public RecipeStrategy() {

    }

    @Override
    public List<Object> getSuggestions() {
        setSuggestions(new ArrayList<>());
        getSuggestionsRecipe().stream().forEach(elem -> this.addSuggestions(elem));
        return getSuggestion();
    }

    @Override
    public void addSuggestion(List<Vegetal> suggestionsVegetal, List<Recipe> suggestionsRecipe) {
        setSuggestionsRecipe(suggestionsRecipe);
    }

    public RecipeStrategy(String name) {
        super(name);
    }
}