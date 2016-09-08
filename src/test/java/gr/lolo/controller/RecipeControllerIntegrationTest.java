package gr.lolo.controller;

import gr.lolo.TestUtil;
import gr.lolo.domain.Recipe;
import gr.lolo.resource.IngredientResource;
import gr.lolo.resource.RecipeResource;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RecipeControllerIntegrationTest {

    @Autowired
    private TestRestTemplate rest;

    @Autowired
    private TestUtil testUtil;

    @After
    public void tearDown() {
        testUtil.wipeAllTestData();
    }

    @Test
    public void creating_recipe_with_the_same_name() {
        Recipe recipe = new Recipe();
        recipe.setTitle("foo1");

        rest.postForEntity("/api/recipes", recipe, Recipe.class);
        ResponseEntity<Recipe> response = rest.postForEntity("/api/recipes", recipe, Recipe.class);

        //assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, response.getStatusCode());
        // TODO add handler for body
    }

    @Test
    public void create_recipe_with_two_ingredients() {
        RecipeResource recipe = new RecipeResource();
        recipe.setName("foo2");

        IngredientResource ingr1 = new IngredientResource();
        ingr1.setName("bar");

        IngredientResource ingr2 = new IngredientResource();
        ingr2.setName("baz");

        recipe.setIngredients(Arrays.asList(ingr1, ingr2));

        ResponseEntity<RecipeResource> response = rest.postForEntity("/api/recipes", recipe, RecipeResource.class);
        assertEquals(2, response.getBody().getIngredients().size());
        // TODO check payload data

    }
}
