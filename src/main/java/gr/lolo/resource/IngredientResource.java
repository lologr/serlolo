package gr.lolo.resource;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

@Getter
@Setter
public class IngredientResource {

    private String id;

    @NotBlank
    private String name;

    private String notes;

    @Override
    public String toString() {
        return "IngredientResource{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
