package gr.lolo.converter;

import gr.lolo.domain.Ingredient;
import gr.lolo.resource.IngredientResource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientConverter implements Converter<Ingredient, IngredientResource> {

    @Override
    public IngredientResource convert(Ingredient source) {
        IngredientResource resource = new IngredientResource();

        resource.setId(source.getSlug());
        resource.setName(source.getName());

        return resource;
    }
}
