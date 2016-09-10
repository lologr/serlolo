package gr.lolo.resource;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

@Getter
@Setter
public class RecipeIngredientResource {

    private String id;

    @NotBlank
    private String name;

    private String notes;

    @Override
    public String toString() {
        return "RecipeIngredientResource{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
