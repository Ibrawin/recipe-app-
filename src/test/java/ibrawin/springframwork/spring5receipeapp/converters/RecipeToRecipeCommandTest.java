package ibrawin.springframwork.spring5receipeapp.converters;

import ibrawin.springframwork.spring5receipeapp.commands.RecipeCommand;
import ibrawin.springframwork.spring5receipeapp.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeToRecipeCommandTest {

    private final static Long ID_VALUE = 1L;
    private final static String DESCRIPTION = "description";
    private final static Integer PREP_TIME = 20;
    private final static Integer COOK_TIME = 35;
    private final static Integer SERVINGS = 4;
    private final static String SOURCE = "hehe";
    private final static String URL = "www.ibrawin.com";
    private final static String DIRECTIONS = "do this do that";
    private final static Difficulty DIFFICULTY = Difficulty.KIND_OF_HARD;
    private final static Long NOTES_ID = 1L;
    private final static Long INGREDIENT_ID1 = 3L;
    private final static Long INGREDIENT_ID2 = 6L;
    private final static Long INGREDIENT_ID3 = 9L;
    private final static Long CATEGORY_ID1 = 6L;
    private final static Long CATEGORY_ID2 = 12L;

    private static RecipeToRecipeCommand converter;

    @BeforeEach
    void setUp() {
        converter = new RecipeToRecipeCommand(new NotesToNotesCommand(),
                new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand()),
                new CategoryToCategoryCommand());
    }

    @Test
    void testNullParameter() {
        assertNull(converter.convert(null));
    }

    @Test
    void testEmptyObject() {
        assertNotNull(converter.convert(new Recipe()));
    }

    @Test
    void convert() {
        //given
        Recipe recipe = new Recipe();
        recipe.setId(ID_VALUE);
        recipe.setDescription(DESCRIPTION);
        recipe.setPrepTime(PREP_TIME);
        recipe.setCookTime(COOK_TIME);
        recipe.setServings(SERVINGS);
        recipe.setSource(SOURCE);
        recipe.setUrl(URL);
        recipe.setDirections(DIRECTIONS);
        recipe.setDifficulty(DIFFICULTY);

        Notes notes = new Notes();
        notes.setId(NOTES_ID);
        recipe.setNotes(notes);

        Ingredient ingredient = new Ingredient();
        ingredient.setId(INGREDIENT_ID1);
        recipe.getIngredients().add(ingredient);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId(INGREDIENT_ID2);
        recipe.getIngredients().add(ingredient2);

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setId(INGREDIENT_ID3);
        recipe.getIngredients().add(ingredient3);

        Category category = new Category();
        category.setId(CATEGORY_ID1);
        recipe.getCategories().add(category);

        Category category2 = new Category();
        category2.setId(CATEGORY_ID2);
        recipe.getCategories().add(category2);

        //when
        RecipeCommand recipeCommand = converter.convert(recipe);

        //then
        assertNotNull(recipeCommand);
        assertNotNull(recipeCommand.getNotes());
        assertEquals(ID_VALUE, recipeCommand.getId());
        assertEquals(DESCRIPTION, recipeCommand.getDescription());
        assertEquals(PREP_TIME, recipeCommand.getPrepTime());
        assertEquals(COOK_TIME, recipeCommand.getCookTime());
        assertEquals(SERVINGS, recipeCommand.getServings());
        assertEquals(SOURCE, recipeCommand.getSource());
        assertEquals(URL, recipeCommand.getUrl());
        assertEquals(DIRECTIONS, recipeCommand.getDirections());
        assertEquals(DIFFICULTY, recipeCommand.getDifficulty());
        assertEquals(NOTES_ID, recipeCommand.getNotes().getId());
        assertEquals(3, recipeCommand.getIngredients().size());
        assertEquals(2, recipeCommand.getCategories().size());
    }
}