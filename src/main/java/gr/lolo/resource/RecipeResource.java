package gr.lolo.resource;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class RecipeResource {

    private String id;
    private String name;
    private List<IngredientResource> ingredients = new ArrayList<>();

}
