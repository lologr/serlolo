package gr.lolo.controller;

import gr.lolo.TestUtil;
import gr.lolo.domain.Ingredient;
import gr.lolo.util.Slugifier;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class IngredientControllerIntegrationTests {

    private static final ParameterizedTypeReference<List<Ingredient>> ingrListType =
            new ParameterizedTypeReference<List<Ingredient>>() {};

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private Slugifier slugifier;

    private Ingredient ingredient;

    @Autowired
    private TestUtil testUtil;

    @Before
    public void setup() {
        ingredient = new Ingredient();
        ingredient.setIngredient("foo");
        ingredient.setSlug(slugifier.slugify(ingredient.getIngredient()));
    }

    @After
    public void tearDown() {
        testUtil.wipeAllTestData();
    }

    @Test
    public void test() {
        ResponseEntity<Ingredient> postResponse = testRestTemplate.postForEntity("/api/ingredients", ingredient, Ingredient.class);
        Ingredient responseIngredient = postResponse.getBody();
        assertEquals(ingredient.getIngredient(), responseIngredient.getIngredient());
        assertEquals(ingredient.getSlug(), responseIngredient.getSlug());

        ResponseEntity<List<Ingredient>> response =
                testRestTemplate.exchange("/api/ingredients", HttpMethod.GET, HttpEntity.EMPTY, ingrListType);
        List<Ingredient> responseIngredients = response.getBody();
        assertEquals(1, responseIngredients.size());
        Ingredient responseFirstIngredient = responseIngredients.get(0);
        assertEquals(ingredient.getIngredient(), responseFirstIngredient.getIngredient());
        assertEquals(ingredient.getSlug(), responseFirstIngredient.getSlug());
    }
}