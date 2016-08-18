package gr.lolo.controller.query;

import gr.lolo.domain.Ingredient;
import gr.lolo.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/query/ingredients")
public class IngredientQueryController {

    @Autowired
    private IngredientRepository ingredientRepository;

    @RequestMapping(value = "/startswith", method = RequestMethod.GET)
    public List<Ingredient> getIngredientsThatStartsWith(
            @RequestParam("name") String name) {
        return ingredientRepository.startsWith(name);
    }
}
