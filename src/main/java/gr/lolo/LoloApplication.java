package gr.lolo;

import gr.lolo.domain.Ingredient;
import gr.lolo.repository.IngredientRepository;
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
    public CommandLineRunner runner(IngredientRepository repository) {
        return args -> {
	    Ingredient ingredient = new Ingredient();
	    ingredient.setName("arakass");

	    repository.save(ingredient);
	};
    }
}
