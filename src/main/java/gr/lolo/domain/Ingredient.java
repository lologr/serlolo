package gr.lolo.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity(name = "ingredient")
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "slug",
        scope = Recipe.class)
public class Ingredient extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id", nullable = false)
    private Long ingredientId;

    @Column(name = "slug", nullable = false)
    private String slug;

    @Column(name = "ingredient", nullable = false)
    private String ingredient;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ingredient_id")
    private Set<RecipeIngredient> recipeIngredients = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ingredient that = (Ingredient) o;

        return ingredientId != null ? ingredientId.equals(that.ingredientId) : that.ingredientId == null;

    }

    @Override
    public int hashCode() {
        return ingredientId != null ? ingredientId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "ingredientId=" + ingredientId +
                ", slug='" + slug + '\'' +
                ", title='" + ingredient + '\'' +
//                ", recipes=" + recipes.stream().map(Recipe::getTitle)
//                .collect(Collectors.joining(",")) +
                '}';
    }
}
