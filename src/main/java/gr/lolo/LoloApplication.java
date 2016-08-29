package gr.lolo;

import gr.lolo.domain.Ingredient;
import gr.lolo.domain.Recipe;
import gr.lolo.repository.IngredientRepository;
import gr.lolo.repository.RecipeRepository;
import gr.lolo.service.IngredientService;
import gr.lolo.service.RecipeService;
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
    public CommandLineRunner cli(RecipeRepository repo,
                                 IngredientService ingredientService,
                                 RecipeService recipeService) {
        return args -> {
//            Ingredient i1 = ingredientService.upsertIngredient("augo");
//            Ingredient i2 = ingredientService.upsertIngredient("patates");
//
//            Recipe r = new Recipe();
//            r.setTitle("auga me patates");
//            r.setSlug("auga-me-patates");
//            Set<Ingredient> ingrs = new HashSet<>(Arrays.asList(i1, i2));
//            r.setIngredients(ingrs);
//
//
//            Recipe rNew = repo.save(r);
////
//            rNew.setPrepTime(5);
//
//            repo.save(rNew);

            System.out.println(recipeService.findRecipeById("auga-me-patates"));



//            recipeService.insert("i1", "a", "b");
//            recipeService.insert("i2", "a", "c");
//            recipeService.insert("i3", "a", "b", "c");
//            recipeService.insert("i4", "b", "c", "d");
//            recipeService.insert("i5", "b", "d", "e");
//            recipeService.insert("i6", "d", "e");
//            recipeService.insert("i7", "e", "f");
//            recipeService.insert("i8", "f", "g", "h");
        };
    }
}
