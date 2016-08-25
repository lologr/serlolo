package gr.lolo.resource;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class RecipeResource {

    private String id;

    @NotBlank
    @Length(min = 4, max = 60)
    // TODO uniqueness!
    private String name;

    @Valid
    @Size(min = 1, max = 20)
    private List<IngredientResource> ingredients = new ArrayList<>();

}
