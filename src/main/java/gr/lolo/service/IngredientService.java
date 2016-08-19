package gr.lolo.service;

import gr.lolo.domain.Ingredient;
import gr.lolo.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    public Ingredient upsetIngredient(String name) {
        Optional<Ingredient> ingr = ingredientRepository.findOneByName(name);
        return ingr.orElseGet(() -> {
            Ingredient newIngr = new Ingredient();
            newIngr.setName(name);
            return ingredientRepository.save(newIngr);
        });
    }

}
