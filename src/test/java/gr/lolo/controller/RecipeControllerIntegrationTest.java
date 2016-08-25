package gr.lolo.controller;

import gr.lolo.domain.Ingredient;
import gr.lolo.domain.Recipe;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RecipeControllerIntegrationTest {

    @Autowired
    private TestRestTemplate rest;

    @Test
    public void creating_recipe_with_the_same_name() {
        Recipe recipe = new Recipe();
        recipe.setName("foo1");

        rest.postForEntity("/api/recipes", recipe, Recipe.class);
        ResponseEntity<Recipe> response = rest.postForEntity("/api/recipes", recipe, Recipe.class);

        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, response.getStatusCode());
        // TODO add handler for body
    }

    @Test
    public void create_recipe_with_two_ingredients() {
        Recipe recipe = new Recipe();
        recipe.setName("foo2");

        Ingredient ingr1 = new Ingredient();
        ingr1.setName("bar");

        Ingredient ingr2 = new Ingredient();
        ingr2.setName("baz");

        recipe.setIngredients(new HashSet<>(Arrays.asList(ingr1, ingr2)));

        ResponseEntity<Recipe> response = rest.postForEntity("/api/recipes", recipe, Recipe.class);
        assertEquals(2, response.getBody().getIngredients().size());
        // TODO check payload data

    }
}
