package gr.lolo.service;

import gr.lolo.converter.RecipeConverter;
import gr.lolo.domain.Ingredient;
import gr.lolo.domain.Recipe;
import gr.lolo.domain.Tag;
import gr.lolo.repository.RecipeRepository;
import gr.lolo.resource.IngredientResource;
import gr.lolo.resource.RecipeResource;
import gr.lolo.resource.TagResource;
import gr.lolo.util.Slugifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private TagService tagService;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private Slugifier slugifier;

    @Autowired
    private RecipeConverter recipeConverter;

//    public Recipe insert(String name, String ingrName, String ... otherIngrNames) {
//        Set<String> ingrs = new HashSet<>(Arrays.asList(otherIngrNames));
//        ingrs.add(ingrName);
//
//        Recipe recipe = new Recipe();
//        recipe.setName(name);
//
//        Set<Ingredient> collect = ingrs.stream().map(ingredientService::upsertIngredient)
//                .collect(Collectors.toSet());
//
//        recipe.setIngredients(collect);
//
//        return save(recipe);
//    }

    @Transactional
    public RecipeResource save(RecipeResource resource) {
        Recipe recipe = new Recipe();
        recipe.setSlug(slugifier.slugify(resource.getName()));
        recipe.setName(resource.getName());

        Set<Ingredient> newIngrs = resource.getIngredients().stream()
                .map(IngredientResource::getName)
                .distinct()
                .map(ingredientService::upsertIngredient)
                .collect(Collectors.toSet());

        recipe.setIngredients(newIngrs);

        Set<Tag> newTags = resource.getTags().stream()
                .map(TagResource::getName)
                .distinct()
                .map(tagService::upsertTag)
                .collect(Collectors.toSet());

        recipe.setTags(newTags);

        return recipeConverter.convert(upsertRecipe(recipe));

    }

    private Recipe upsertRecipe(Recipe recipe) {
        Optional<Recipe> foundByName = recipeRepository.findOneByName(recipe.getName());
        if (foundByName.isPresent()) {
            Recipe existingRecipe = foundByName.get();
            existingRecipe.setIngredients(recipe.getIngredients());
            return recipeRepository.save(existingRecipe);
        }
        return recipeRepository.save(recipe);
    }

    public List<RecipeResource> findAllRecipes() {
        return recipeRepository.findAll()
                .stream()
                .map(recipeConverter::convert)
                .collect(Collectors.toList());
    }

    public RecipeResource findRecipeById(String id) {
        return recipeRepository.findOneBySlug(id)
                .map(recipeConverter::convert)
                .orElseThrow(() -> new IllegalArgumentException()); // TODO exception
    }
}
