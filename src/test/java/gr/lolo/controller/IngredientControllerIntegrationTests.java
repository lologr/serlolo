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
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class IngredientControllerIntegrationTests {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private IngredientRepository repository;

    private Ingredient ingredient;

    @Before
    public void setup() {
        ingredient = new Ingredient();
        ingredient.setId(1L);
        ingredient.setName("foo");
        repository.save(ingredient);
    }

    @Test
    public void test() {
        ParameterizedTypeReference<List<Ingredient>> type = new ParameterizedTypeReference<List<Ingredient>>() {};
        ResponseEntity<List<Ingredient>> response =
                testRestTemplate.exchange("/api/ingredients", HttpMethod.GET, HttpEntity.EMPTY, type);
        assertEquals(Arrays.asList(ingredient), response.getBody());
    }
}