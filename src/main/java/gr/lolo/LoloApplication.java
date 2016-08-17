package gr.lolo;

import gr.lolo.domain.Ingredient;
import gr.lolo.domain.Recipe;
import gr.lolo.repository.IngredientRepository;
import gr.lolo.repository.RecipeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class LoloApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoloApplication.class, args);
    }

    @Bean
    public CommandLineRunner cli(RecipeRepository repo) {
        return args -> {
            Ingredient i1 = Ingredient.of(0L, "aygo", new HashSet<>());
            Ingredient i2 = Ingredient.of(0L, "patata", new HashSet<>());

            Recipe r = new Recipe();
            r.setName("auga me patates");
            Set<Ingredient> ingrs = new HashSet<>(Arrays.asList(i1, i2));
            r.setIngredients(ingrs);
//            r.addIngredient(i1);
//            r.addIngredient(i2);

            repo.save(r);
        };
    }
}
