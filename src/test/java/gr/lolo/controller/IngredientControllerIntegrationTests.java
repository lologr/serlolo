package gr.lolo.controller;

import gr.lolo.domain.Ingredient;
import gr.lolo.repository.IngredientRepository;
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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class IngredientControllerIntegrationTests {

    private static final ParameterizedTypeReference<List<Ingredient>> ingrListType =
            new ParameterizedTypeReference<List<Ingredient>>() {};

    @Autowired
    private TestRestTemplate testRestTemplate;

    private Ingredient ingredient;

    @Before
    public void setup() {
        ingredient = new Ingredient();
        ingredient.setId(1L);
        ingredient.setName("foo");
    }

    @Test
    public void test() {
        ResponseEntity<Ingredient> postResponse = testRestTemplate.postForEntity("/api/ingredients", ingredient, Ingredient.class);
        assertEquals(ingredient, postResponse.getBody());
        ResponseEntity<List<Ingredient>> response =
                testRestTemplate.exchange("/api/ingredients", HttpMethod.GET, HttpEntity.EMPTY, ingrListType);
        assertEquals(Arrays.asList(ingredient), response.getBody());
    }
}