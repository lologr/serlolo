package gr.lolo.controller.query;

import gr.lolo.domain.Ingredient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/query/recipe")
public class RecipeQueryController {

    @RequestMapping(value = "/related", method = RequestMethod.GET)
    public List<Ingredient> getRelatedRecipes(
            @RequestParam("ingredients") List<String> ingredients) {

        throw new UnsupportedOperationException("Not implemented yet baby!");
    }
}
