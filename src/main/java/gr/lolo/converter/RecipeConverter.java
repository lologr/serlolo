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
    private IngredientConverter ingredientConverter;

    @Override
    public RecipeResource convert(Recipe recipe) {
        RecipeResource resource = new RecipeResource();

        resource.setId(recipe.getSlug());
        resource.setName(recipe.getName());

        resource.setIngredients(recipe.getIngredients()
                .stream().map(ingredientConverter::convert)
                .collect(Collectors.toList()));

        return resource;
    }
}
