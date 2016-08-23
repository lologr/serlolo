package gr.lolo.service;

import gr.lolo.domain.Ingredient;
import gr.lolo.domain.Recipe;
import gr.lolo.repository.RecipeRepository;
import gr.lolo.util.Slugifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private Slugifier slugifier;

    public Recipe insert(String name, String ingrName, String ... otherIngrNames) {
        Set<String> ingrs = new HashSet<>(Arrays.asList(otherIngrNames));
        ingrs.add(ingrName);

        Recipe recipe = new Recipe();
        recipe.setName(name);

        Set<Ingredient> collect = ingrs.stream().map(ingredientService::upsertIngredient)
                .collect(Collectors.toSet());

        recipe.setIngredients(collect);

        return save(recipe);
    }

    @Transactional
    public Recipe save(Recipe recipe) {
        // TODO copy!
        recipe.setSlug(slugifier.slugify(recipe.getName())); // TODO check existing!

        Set<Ingredient> newIngrs = recipe.getIngredients().stream()
                .map(Ingredient::getName)
                .map(ingredientService::upsertIngredient).collect(Collectors.toSet());

        recipe.setIngredients(newIngrs);

        return recipeRepository.save(recipe);

    }
}
