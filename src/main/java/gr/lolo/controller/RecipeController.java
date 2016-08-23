package gr.lolo.controller;

import gr.lolo.domain.Recipe;
import gr.lolo.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @RequestMapping(method = RequestMethod.POST)
    public Recipe createRecipe(@Valid @RequestBody Recipe recipe) {
        return recipeService.save(recipe);
    }
}
