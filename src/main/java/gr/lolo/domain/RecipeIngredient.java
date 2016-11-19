package gr.lolo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@IdClass(RecipeIngredientKey.class)
public class RecipeIngredient extends BaseModel {

    @Id
    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @Id
    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    @ManyToOne
    @JoinColumn(name = "unit")
    private Unit unit;

    private double quantity;

    private String slug;

    private String name;

    private String notes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecipeIngredient that = (RecipeIngredient) o;

        if (!recipe.equals(that.recipe)) return false;
        return ingredient.equals(that.ingredient);

    }

    @Override
    public int hashCode() {
        int result = recipe.hashCode();
        result = 31 * result + ingredient.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "RecipeIngredient{" +
                "recipeId=" + recipe.getRecipeId() +
                ", ingredientId=" + ingredient.getIngredientId() +
                ", name='" + name + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
