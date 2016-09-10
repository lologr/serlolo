package gr.lolo.converter;

import gr.lolo.domain.RecipeIngredient;
import gr.lolo.resource.RecipeIngredientResource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RecipeIngredientConverter implements Converter<RecipeIngredient, RecipeIngredientResource> {

    @Override
    public RecipeIngredientResource convert(RecipeIngredient source) {
        RecipeIngredientResource resource = new RecipeIngredientResource();

        resource.setId(source.getSlug());
        resource.setName(source.getName());
        resource.setNotes(source.getNotes());

        return resource;
    }
}
