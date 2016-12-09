package gr.lolo.service;

import gr.lolo.converter.IngredientConverter;
import gr.lolo.domain.Ingredient;
import gr.lolo.domain.Recipe;
import gr.lolo.domain.RecipeIngredient;
import gr.lolo.resource.IngredientResource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IngredientServiceTest {

    @Autowired
    IngredientService service;

    @Autowired
    IngredientConverter converter;

    private List<Ingredient> ingredients;
    private Ingredient ingredient1;
    private Ingredient ingredient2;
    private Ingredient ingredient3;

    @Before
    public void setup() {
        Recipe recipe1 = new Recipe();

        ingredient1 = new Ingredient();
        ingredient1.setIngredient("ingredient " + 1);

        ingredient2 = new Ingredient();
        ingredient2.setIngredient("ingredient " + 2);

        ingredient3 = new Ingredient();
        ingredient3.setIngredient("ingredient " + 3);

        Ingredient ingredient4 =  new Ingredient();
        ingredient4.setIngredient("ingredient " + 4);

        RecipeIngredient r1I1 = createRecipeIngredient(recipe1, ingredient1);
        RecipeIngredient r1I2 = createRecipeIngredient(recipe1, ingredient2);
        RecipeIngredient r1I3 = createRecipeIngredient(recipe1, ingredient3);

        ingredient1.getRecipeIngredients().add(r1I1);
        ingredient2.getRecipeIngredients().add(r1I2);
        ingredient3.getRecipeIngredients().add(r1I3);

        Recipe recipe2 = new Recipe();

        RecipeIngredient r2I1 = createRecipeIngredient(recipe2, ingredient1);
        RecipeIngredient r2I2 = createRecipeIngredient(recipe2, ingredient2);

        ingredient1.getRecipeIngredients().add(r2I1);
        ingredient2.getRecipeIngredients().add(r2I2);

        Recipe recipe3 = new Recipe();

        RecipeIngredient r3I1 = createRecipeIngredient(recipe3, ingredient1);

        ingredient1.getRecipeIngredients().add(r3I1);

        ingredients = Arrays.asList(ingredient1, ingredient2, ingredient3, ingredient4);

    }

    private RecipeIngredient createRecipeIngredient(Recipe recipe, Ingredient ingredient) {
        RecipeIngredient recipeIngredient = new RecipeIngredient();
        recipeIngredient.setRecipe(recipe);
        recipeIngredient.setIngredient(ingredient);
        return recipeIngredient;
    }

    @Test
    public void get_resource_sorted_by_number_of_recipes_test() throws Exception {
        List<IngredientResource> sortedByNumberOfRecipes = service.getResourceSortedByNumberOfRecipes(ingredients, 3);
        assertThat(sortedByNumberOfRecipes,
                contains(converter.convert(ingredient1),
                        converter.convert(ingredient2),
                        converter.convert(ingredient3)));
    }
}