package gr.lolo.resource;

import gr.lolo.domain.Recipe;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data(staticConstructor = "of")
public class RelatedRecipes {

    private Map<Integer, List<Recipe>> recipes = new HashMap<>();

}
