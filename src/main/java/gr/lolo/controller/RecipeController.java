package gr.lolo.controller;

import gr.lolo.resource.RecipeResource;
import gr.lolo.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @RequestMapping(method = RequestMethod.POST)
    public RecipeResource createRecipe(@Valid @RequestBody RecipeResource recipe) {
        return recipeService.save(recipe);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<RecipeResource> findAllRecipes() {
        return recipeService.findAllRecipes();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public RecipeResource getRecipeById(@PathVariable("id") String id) {
        return recipeService.findRecipeById(id);
    }
}
