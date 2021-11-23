package oo2.agricultura.model;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class InfoStrategy extends Strategy{

    public InfoStrategy(String name) {
        super(name);
    }

    public InfoStrategy() {

    }

    @Override
    public List<Object> getSuggestions() {
        setSuggestions(new ArrayList<>());
        getSuggestionsVegetals().stream().forEach(elem -> this.addSuggestions(elem));
        return getSuggestion();
    }

    @Override
    public void addSuggestion(List<Vegetal> suggestionsVegetal, List<Recipe> suggestionsRecipe) {
        setSuggestionsVegetals(suggestionsVegetal);
    }


}