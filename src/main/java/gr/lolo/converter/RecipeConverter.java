package gr.lolo.converter;

import gr.lolo.domain.Recipe;
import gr.lolo.resource.RecipeResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RecipeConverter implements Converter<Recipe, RecipeResource> {

    @Autowired
    private RecipeIngredientConverter ingredientConverter;

    @Autowired
    private TagConverter tagConverter;

    @Override
    public RecipeResource convert(Recipe recipe) {
        RecipeResource resource = new RecipeResource();

        resource.setId(recipe.getSlug());
        resource.setName(recipe.getTitle());

        resource.setIngredients(recipe.getRecipeIngredients()
                .stream().map(ingredientConverter::convert)
                .collect(Collectors.toList()));

        resource.setTags(recipe.getTags()
                .stream().map(tagConverter::convert)
                .collect(Collectors.toList()));

        return resource;
    }
}
