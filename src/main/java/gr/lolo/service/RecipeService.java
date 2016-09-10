package gr.lolo.service;

import gr.lolo.converter.RecipeConverter;
import gr.lolo.domain.Ingredient;
import gr.lolo.domain.Recipe;
import gr.lolo.domain.RecipeIngredient;
import gr.lolo.domain.Tag;
import gr.lolo.repository.IngredientRepository;
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

    @Autowired
    private IngredientRepository ingredientRepository;

    @Transactional
    public RecipeResource save(RecipeResource resource) {
        Recipe recipe = new Recipe();
        recipe.setSlug(slugifier.slugify(resource.getName()));
        recipe.setTitle(resource.getName());

        Set<Tag> newTags = resource.getTags().stream()
                .map(TagResource::getName)
                .distinct()
                .map(tagService::upsertTag)
                .collect(Collectors.toSet());

        recipe.setTags(newTags);

        recipe = recipeRepository.save(recipe);

        getRecipeIngredients(resource, recipe).forEach(ingr -> {
            ingredientRepository.save(ingr);
        });

        return recipeConverter.convert(recipeRepository.findOne(recipe.getRecipeId()));
    }

    private List<Ingredient> getRecipeIngredients(RecipeResource resource, Recipe recipe) {
        return resource.getIngredients().stream()
                    .map(i -> {
                        Ingredient ingr = new Ingredient();
                        ingr.setSlug(i.getName());
                        ingr.setIngredient(i.getName());
                        RecipeIngredient recIngr = new RecipeIngredient();
                        recIngr.setRecipe(recipe);
                        recIngr.setIngredient(ingr);
                        recIngr.setSlug(recipe.getSlug() + "-" + slugifier.slugify(i.getName()));
                        recIngr.setName(i.getName());
                        recIngr.setNotes(i.getNotes());
                        ingr.getRecipeIngredients().add(recIngr);
                        return ingr;
                    })
                    .collect(Collectors.toList());
    }

//    private Recipe upsertRecipe(Recipe recipe) {
//        Optional<Recipe> foundByName = recipeRepository.findOneByTitle(recipe.getTitle());
//        if (foundByName.isPresent()) {
//            Recipe existingRecipe = foundByName.get();
//            existingRecipe.setIngredients(recipe.getIngredients());
//            return recipeRepository.save(existingRecipe);
//        }
//        return recipeRepository.save(recipe);
//    }

    public List<RecipeResource> findAllRecipes() {
        return recipeRepository.findAll()
                .stream()
                .map(recipeConverter::convert)
                .collect(Collectors.toList());
    }

    @Transactional
    public RecipeResource findRecipeById(String id) {
        return recipeRepository.findOneBySlug(id)
                .map(recipeConverter::convert)
                .orElseThrow(() -> new IllegalArgumentException()); // TODO exception
    }
}
