package gr.lolo.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class RecipeIngredientKey implements Serializable {
    private Recipe recipe;
    private Ingredient ingredient;
}
