package gr.lolo.controller;

import gr.lolo.domain.Ingredient;
import gr.lolo.repository.IngredientRepository;
import gr.lolo.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private IngredientService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Ingredient createIngredient(@RequestBody Ingredient ingredient) {
        service.slugify(ingredient);
        return ingredientRepository.save(ingredient);
    }
}
