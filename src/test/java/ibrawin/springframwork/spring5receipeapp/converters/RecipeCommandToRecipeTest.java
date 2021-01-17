package ibrawin.springframwork.spring5receipeapp.converters;

import ibrawin.springframwork.spring5receipeapp.commands.CategoryCommand;
import ibrawin.springframwork.spring5receipeapp.commands.IngredientCommand;
import ibrawin.springframwork.spring5receipeapp.commands.NotesCommand;
import ibrawin.springframwork.spring5receipeapp.commands.RecipeCommand;
import ibrawin.springframwork.spring5receipeapp.domain.Difficulty;
import ibrawin.springframwork.spring5receipeapp.domain.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeCommandToRecipeTest {

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


    private static RecipeCommandToRecipe converter;

    @BeforeEach
    void setUp() {
        converter = new RecipeCommandToRecipe(new NotesCommandToNotes(),
                new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure()),
                new CategoryCommandToCategory());
    }

    @Test
    void testNullParameter() {
        assertNull(converter.convert(null));
    }

    @Test
    void testEmptyObject() {
        assertNotNull(converter.convert(new RecipeCommand()));
    }

    @Test
    void convert() {
        //given
        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(ID_VALUE);
        recipeCommand.setDescription(DESCRIPTION);
        recipeCommand.setPrepTime(PREP_TIME);
        recipeCommand.setCookTime(COOK_TIME);
        recipeCommand.setServings(SERVINGS);
        recipeCommand.setSource(SOURCE);
        recipeCommand.setUrl(URL);
        recipeCommand.setDirections(DIRECTIONS);
        recipeCommand.setDifficulty(DIFFICULTY);

        NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(NOTES_ID);
        recipeCommand.setNotes(notesCommand);

        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(INGREDIENT_ID1);
        recipeCommand.getIngredients().add(ingredientCommand);

        IngredientCommand ingredientCommand2 = new IngredientCommand();
        ingredientCommand2.setId(INGREDIENT_ID2);
        recipeCommand.getIngredients().add(ingredientCommand2);

        IngredientCommand ingredientCommand3 = new IngredientCommand();
        ingredientCommand3.setId(INGREDIENT_ID3);
        recipeCommand.getIngredients().add(ingredientCommand3);

        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(CATEGORY_ID1);
        recipeCommand.getCategories().add(categoryCommand);

        CategoryCommand categoryCommand2 = new CategoryCommand();
        categoryCommand2.setId(CATEGORY_ID2);
        recipeCommand.getCategories().add(categoryCommand2);

        //when
        Recipe recipe = converter.convert(recipeCommand);

        //then
        assertNotNull(recipe);
        assertNotNull(recipe.getNotes());
        assertEquals(ID_VALUE, recipe.getId());
        assertEquals(DESCRIPTION, recipe.getDescription());
        assertEquals(PREP_TIME, recipe.getPrepTime());
        assertEquals(COOK_TIME, recipe.getCookTime());
        assertEquals(SERVINGS, recipe.getServings());
        assertEquals(SOURCE, recipe.getSource());
        assertEquals(URL, recipe.getUrl());
        assertEquals(DIRECTIONS, recipe.getDirections());
        assertEquals(DIFFICULTY, recipe.getDifficulty());
        assertEquals(NOTES_ID, recipe.getNotes().getId());
        assertEquals(3, recipe.getIngredients().size());
        assertEquals(2, recipe.getCategories().size());
    }
}