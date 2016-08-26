package gr.lolo.controller.query;

import gr.lolo.repository.IngredientRepository;
import gr.lolo.resource.IngredientResource;
import gr.lolo.service.IngredientService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Collections.EMPTY_LIST;

@RestController
@RequestMapping("/api/query/ingredients")
public class IngredientQueryController {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private IngredientService ingredientService;

    @RequestMapping(value = "/startwith", method = RequestMethod.GET)
    public List<IngredientResource> getIngredientsThatStartWith(
            @RequestParam("name") String name) {
        return StringUtils.isEmpty(name) ?
                EMPTY_LIST : ingredientService.getResourceSortedByNumberOfRecipes(ingredientRepository.startWith(name), 10);
    }
}
