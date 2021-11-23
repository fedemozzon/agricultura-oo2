package oo2.agricultura.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "strategies")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Strategy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Transient
    private List<Object> suggestions;
    @Transient
    private List<Recipe> suggestionsRecipe;
    @Transient
    private List<Vegetal> suggestionsVegetals;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Strategy(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public void setSuggestions(List<Object> suggestions) {
        this.suggestions = suggestions;
    }

    public void setSuggestionsRecipe(List<Recipe> suggestionsRecipe) {
        this.suggestionsRecipe = suggestionsRecipe;
    }

    public void setSuggestionsVegetals(List<Vegetal> suggestionsVegetals) {
        this.suggestionsVegetals = suggestionsVegetals;
    }

    public List<Object> getSuggestions() {
        return suggestions;
    }

    public List<Object> getSuggestion() {
        return suggestions;
    }

    public List<Recipe> getSuggestionsRecipe() {
        return suggestionsRecipe;
    }

    public List<Vegetal> getSuggestionsVegetals() {
        return suggestionsVegetals;
    }

    public Strategy() {
        this.suggestions = new ArrayList<>();
        this.suggestionsRecipe = new ArrayList<>();
        this.suggestionsVegetals = new ArrayList<>();
    }

    public void addSuggestion(List<Vegetal> suggestionsVegetals, List<Recipe> suggestionsRecipe){}
    public void addSuggestions(Object elem){
        suggestions.add(elem);
    }
}