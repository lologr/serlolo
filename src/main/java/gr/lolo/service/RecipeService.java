package gr.lolo.service;

import gr.lolo.domain.Recipe;
import gr.lolo.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class RecipeService {

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private RecipeRepository recipeRepository;

    @Transactional
    public Recipe insert(String name, String ingrName, String ... otherIngrNames) {
        Set<String> ingrs = new HashSet<>(Arrays.asList(otherIngrNames));
        ingrs.add(ingrName);

        Recipe recipe = new Recipe();
        recipe.setName(name);

        ingrs.stream().map(ingredientService::upsetIngredient)
                .forEach(ingr -> {
                    recipe.addIngredient(ingr);
                });

        return recipeRepository.save(recipe);
    }
}
