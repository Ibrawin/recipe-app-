package ibrawin.springframwork.spring5receipeapp.controllers;

import ibrawin.springframwork.spring5receipeapp.domain.Recipe;
import ibrawin.springframwork.spring5receipeapp.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


public class RecipeControllerTest {

    private RecipeController recipeController;

    @Mock
    private RecipeService recipeService;

    MockMvc mockMvc;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        recipeController = new RecipeController(recipeService);
        mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();
    }

    @Test
    public void getRecipe() throws Exception {
        //when
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        when(recipeService.getRecipes()).thenReturn(anySet());

        mockMvc.perform(get("/recipe/show/" + recipe.getId()))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/show"));


    }
}
