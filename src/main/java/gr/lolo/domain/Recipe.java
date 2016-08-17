package gr.lolo.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
//@AllArgsConstructor(staticName = "of")
@EqualsAndHashCode
@Getter
@Setter
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Ingredient> ingredients = new HashSet<>();

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
        ingredient.getRecipes().add(this);
    }
}
