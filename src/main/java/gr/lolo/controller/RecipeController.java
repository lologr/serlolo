package gr.lolo.controller;

import gr.lolo.resource.RecipeResource;
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
    public RecipeResource createRecipe(@Valid @RequestBody RecipeResource recipe) {
        return recipeService.save(recipe);
    }
}
