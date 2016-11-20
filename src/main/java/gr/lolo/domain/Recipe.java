package gr.lolo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
public class Recipe extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id", nullable = false)
    private Long recipeId;

    @Column(name = "slug", nullable = false)
    private String slug;

    @Column(unique = true)
    private String title;

    @Type(type = "gr.lolo.usertype.StringListType")
    @Column(name = "instructions")
    private List<String> instructions = new LinkedList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_id")
    private Set<RecipeIngredient> recipeIngredients = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "recipe_tag",
            joinColumns = @JoinColumn(name = "recipe_id", referencedColumnName = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "tag_id")
    )
    private Set<Tag> tags = new HashSet<>();

    @Column(name = "prep_time")
    private Integer prepTime;

    private Integer difficulty;

//    public void addIngredient(Ingredient ingredient) {
//        ingredients.add(ingredient);
//        ingredient.getRecipes().add(this);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recipe recipe = (Recipe) o;

        return recipeId != null ? recipeId.equals(recipe.recipeId) : recipe.recipeId == null;

    }

    @Override
    public int hashCode() {
        return recipeId != null ? recipeId.hashCode() : 0;
    }
}
