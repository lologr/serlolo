package gr.lolo;

import gr.lolo.repository.IngredientRepository;
import gr.lolo.repository.RecipeRepository;
import gr.lolo.service.RecipeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LoloApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoloApplication.class, args);
    }

    @Bean
    public CommandLineRunner cli(RecipeRepository repo,
                                 IngredientRepository ingrRepo,
                                 RecipeService recipeService) {
        return args -> {
//            Ingredient i1 = new Ingredient();
//            i1.setName("augo");
//            i1 = ingrRepo.save(i1);
//            Ingredient i2 = new Ingredient();
//            i2.setName("patata");
//            i2 = ingrRepo.save(i2);
//
//            Recipe r = new Recipe();
//            r.setName("auga me patates");
//            Set<Ingredient> ingrs = new HashSet<>(Arrays.asList(i1, i2));
//            r.setIngredients(ingrs);
//            r.addIngredient(i1);
//            r.addIngredient(i2);

//            repo.save(r);

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
