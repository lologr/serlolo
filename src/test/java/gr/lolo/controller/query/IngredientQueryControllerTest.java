package gr.lolo.controller.query;

import gr.lolo.converter.IngredientConverter;
import gr.lolo.domain.Ingredient;
import gr.lolo.repository.IngredientRepository;
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

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.contains;
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
    private IngredientConverter ingredientConverter;

    @Autowired
    private Slugifier slugifier;

    private Ingredient testIngredient1;
    private Ingredient testIngredient2;

    @Before
    public void setup() {

        List<Ingredient> ingredients = IntStream.range(1, 10).mapToObj(i -> {
            Ingredient ingredient = new Ingredient();
            ingredient.setIngredient("ingredient " + 1);
            ingredient.setSlug(slugifier.slugify(ingredient.getIngredient()));
            return ingredient;
        }).collect(toList());

        testIngredient1 = new Ingredient();
        testIngredient1.setIngredient("test ingredient 1");
        testIngredient1.setSlug(slugifier.slugify(testIngredient1.getIngredient()));

        testIngredient2 = new Ingredient();
        testIngredient2.setIngredient("test ingredient 2");
        testIngredient2.setSlug(slugifier.slugify(testIngredient2.getIngredient()));

        Ingredient falseTestIngredient3 = new Ingredient();
        falseTestIngredient3.setIngredient("ingredient test 3");
        falseTestIngredient3.setSlug(slugifier.slugify(falseTestIngredient3.getIngredient()));

        ingredients.add(testIngredient1);
        ingredients.add(testIngredient2);
        ingredients.add(falseTestIngredient3);

        ingredientRepository.save(ingredients);

    }

    @Test
    public void get_ingredients_that_start_with_test() {
        UriComponentsBuilder builder =
                UriComponentsBuilder.fromPath("/api/query/ingredients/startwith").queryParam("name", "");

        ResponseEntity<List<IngredientResource>> response =
                testRestTemplate.exchange(builder.build().encode().toUri().toString(), HttpMethod.GET, HttpEntity.EMPTY, ingrListType);

        assertTrue(response.getBody().isEmpty());


        builder = UriComponentsBuilder.fromPath("/api/query/ingredients/startwith").queryParam("name", "test");

        response = testRestTemplate.exchange(builder.build().encode().toUri().toString(), HttpMethod.GET, HttpEntity.EMPTY, ingrListType);

        List<IngredientResource> responseIngredients = response.getBody();

        IngredientResource ingredientResource1 = ingredientConverter.convert(testIngredient1);

        IngredientResource ingredientResource2 = ingredientConverter.convert(testIngredient2);

        assertThat(responseIngredients, contains(ingredientResource1, ingredientResource2));

    }


}