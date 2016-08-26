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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IngredientResource that = (IngredientResource) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return name.equals(that.name);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "IngredientResource{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
