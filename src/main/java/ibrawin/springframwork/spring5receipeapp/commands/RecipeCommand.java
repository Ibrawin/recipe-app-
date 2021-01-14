package ibrawin.springframwork.spring5receipeapp.commands;

import ibrawin.springframwork.spring5receipeapp.domain.Category;
import ibrawin.springframwork.spring5receipeapp.domain.Difficulty;
import ibrawin.springframwork.spring5receipeapp.domain.Ingredient;
import ibrawin.springframwork.spring5receipeapp.domain.Notes;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RecipeCommand {
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Difficulty difficulty;
    private Notes notes;
    private Set<Ingredient> ingredients = new HashSet<>();
    private Set<Category> categories = new HashSet<>();

}
