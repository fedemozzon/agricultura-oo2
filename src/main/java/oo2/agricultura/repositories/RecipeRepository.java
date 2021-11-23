package oo2.agricultura.repositories;

import oo2.agricultura.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

}