package gr.lolo.controller.query;

import gr.lolo.converter.IngredientConverter;
import gr.lolo.domain.Ingredient;
import gr.lolo.domain.Recipe;
import gr.lolo.repository.IngredientRepository;
import gr.lolo.repository.RecipeRepository;
import gr.lolo.resource.IngredientResource;
import gr.lolo.util.Slugifier;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IngredientQueryControllerTest {

    private static final ParameterizedTypeReference<List<IngredientResource>> ingrListType =
            new ParameterizedTypeReference<List<IngredientResource>>() {};

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private IngredientConverter ingredientConverter;

    @Autowired
    private Slugifier slugifier;

    private Ingredient fooIngredient;
    private Ingredient ingredient1, ingredient2, ingredient3, ingredient4, ingredient5, ingredient6, ingredient7,
            ingredient8, ingredient9, ingredient10, ingredient11;
    private Recipe recipe1, recipe2, recipe3;
    private List<Ingredient> ingredients;

    @Before
    public void setup() {
        recipe1 = new Recipe();
        recipe1.setName("recipe one");
        recipe1.setSlug(slugifier.slugify(recipe1.getName()));

        recipe2 = new Recipe();
        recipe2.setName("recipe two");
        recipe2.setSlug(slugifier.slugify(recipe2.getName()));

        recipe3 = new Recipe();
        recipe3.setName("recipe three");
        recipe3.setSlug(slugifier.slugify(recipe3.getName()));

        fooIngredient = new Ingredient();
        fooIngredient.setName("foo ingredient");
        fooIngredient.setSlug(slugifier.slugify(fooIngredient.getName()));

        ingredient1 = new Ingredient();
        ingredient1.setName("ingredient one");
        ingredient1.setSlug(slugifier.slugify(ingredient1.getName()));

        ingredient2 = new Ingredient();
        ingredient2.setName("ingredient two");
        ingredient2.setSlug(slugifier.slugify(ingredient2.getName()));

        ingredient3 = new Ingredient();
        ingredient3.setName("ingredient three");
        ingredient3.setSlug(slugifier.slugify(ingredient3.getName()));

        ingredient4 = new Ingredient();
        ingredient4.setName("ingredient four");
        ingredient4.setSlug(slugifier.slugify(ingredient4.getName()));

        ingredient5 = new Ingredient();
        ingredient5.setName("ingredient five");
        ingredient5.setSlug(slugifier.slugify(ingredient5.getName()));

        ingredient6 = new Ingredient();
        ingredient6.setName("ingredient six");
        ingredient6.setSlug(slugifier.slugify(ingredient6.getName()));

        ingredient7 = new Ingredient();
        ingredient7.setName("ingredient seven");
        ingredient7.setSlug(slugifier.slugify(ingredient7.getName()));

        ingredient8 = new Ingredient();
        ingredient8.setName("ingredient eight");
        ingredient8.setSlug(slugifier.slugify(ingredient8.getName()));

        ingredient9 = new Ingredient();
        ingredient9.setName("ingredient NEEEIN");
        ingredient9.setSlug(slugifier.slugify(ingredient9.getName()));

        ingredient10 = new Ingredient();
        ingredient10.setName("ingredient ten");
        ingredient10.setSlug(slugifier.slugify(ingredient10.getName()));

        ingredient11 = new Ingredient();
        ingredient11.setName("ingredient eleven");
        ingredient11.setSlug(slugifier.slugify(ingredient11.getName()));

        ingredients = new ArrayList<>(asList(fooIngredient, ingredient1, ingredient2, ingredient3, ingredient4, ingredient5,
                ingredient6, ingredient7, ingredient8, ingredient9, ingredient10, ingredient11));

        ingredientRepository.save(ingredients);

        recipe1.addIngredient(ingredient2);

        recipe1.addIngredient(ingredient3);
        recipe2.addIngredient(ingredient3);
        recipe3.addIngredient(ingredient3);

        recipe1.addIngredient(ingredient4);
        recipe2.addIngredient(ingredient4);

        recipe1 = recipeRepository.save(recipe1);
        recipe2 = recipeRepository.save(recipe2);
        recipe3 = recipeRepository.save(recipe3);
    }

    @Test
    public void get_ingredients_that_start_with_test() {
        UriComponentsBuilder builder =
                UriComponentsBuilder.fromPath("/api/query/ingredients/startwith").queryParam("name", "");

        ResponseEntity<List<IngredientResource>> response =
                testRestTemplate.exchange(builder.build().encode().toUri().toString(), HttpMethod.GET, HttpEntity.EMPTY, ingrListType);
        assertTrue(response.getBody().isEmpty());


        builder =
                UriComponentsBuilder.fromPath("/api/query/ingredients/startwith").queryParam("name", "ingredient");

        response =
                testRestTemplate.exchange(builder.build().encode().toUri().toString(), HttpMethod.GET, HttpEntity.EMPTY, ingrListType);
        List<IngredientResource> responseIngredients = response.getBody();

        IngredientResource ingredientResource3 = new IngredientResource();
        ingredientResource3.setName(ingredient3.getName());
        ingredientResource3.setId(ingredient3.getSlug());

        IngredientResource ingredientResource4 = new IngredientResource();
        ingredientResource4.setName(ingredient4.getName());
        ingredientResource4.setId(ingredient4.getSlug());

        IngredientResource ingredientResource2 = new IngredientResource();
        ingredientResource2.setName(ingredient2.getName());
        ingredientResource2.setId(ingredient2.getSlug());

        List<IngredientResource> ingredientResources = ingredients.stream()
                .map(ingredientConverter::convert).collect(toList());


        assertThat(responseIngredients.subList(0, 3), contains(ingredientResource3, ingredientResource4, ingredientResource2));


        ingredientResources.remove(ingredientResource3);
        ingredientResources.remove(ingredientResource4);
        ingredientResources.remove(ingredientResource2);
        ingredientResources.removeIf(ingredientResource -> ingredientResource.getName().equals(ingredient11.getName()));
        ingredientResources.removeIf(ingredientResource -> ingredientResource.getName().equals(fooIngredient.getName()));
        assertThat(responseIngredients.subList(3, responseIngredients.size()),
                containsInAnyOrder(ingredientResources.toArray()));
    }


}