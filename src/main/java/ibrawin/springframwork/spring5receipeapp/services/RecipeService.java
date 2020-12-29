package ibrawin.springframwork.spring5receipeapp.services;

import ibrawin.springframwork.spring5receipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
