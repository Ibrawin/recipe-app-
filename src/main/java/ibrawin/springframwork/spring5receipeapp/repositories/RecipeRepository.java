package ibrawin.springframwork.spring5receipeapp.repositories;

import ibrawin.springframwork.spring5receipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
