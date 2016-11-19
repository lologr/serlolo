package gr.lolo;

import gr.lolo.domain.Ingredient;
import gr.lolo.domain.Recipe;
import gr.lolo.domain.RecipeIngredient;
import gr.lolo.domain.Unit;
import gr.lolo.repository.RecipeRepository;
import gr.lolo.repository.UnitRepository;
import gr.lolo.service.IngredientService;
import gr.lolo.service.RecipeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static org.hibernate.validator.internal.util.CollectionHelper.asSet;

@SpringBootApplication
public class LoloApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoloApplication.class, args);
    }

    @Bean
    public CommandLineRunner cli(RecipeRepository repo,
                                 IngredientService ingredientService,
                                 UnitRepository unitRepository) {
        return args -> {
            repo.deleteAll();
            Ingredient i1 = ingredientService.upsertIngredient("augo");
            Ingredient i2 = ingredientService.upsertIngredient("patates");


            Unit unit = new Unit();
            unit.setSlug("gr");
            unit.setName("gr");
            unit = unitRepository.save(unit);


            Recipe r = new Recipe();
            r.setTitle("auga me patates");
            r.setSlug("auga-me-patates");
            r = repo.save(r);

            RecipeIngredient ri1 = new RecipeIngredient();
            ri1.setRecipe(r);
            ri1.setIngredient(i1);
            ri1.setSlug(r.getSlug() + "-" + i1.getSlug());
            ri1.setUnit(unit);
            ri1.setQuantity(4.2);

            RecipeIngredient ri2 = new RecipeIngredient();
            ri2.setRecipe(r);
            ri2.setIngredient(i2);
            ri2.setSlug(r.getSlug() + "-" + i2.getSlug());
            ri2.setUnit(unit);
            ri2.setQuantity(3.2);

            r.setRecipeIngredients(asSet(ri1, ri2));

            r = repo.save(r);
        };
    }
}
