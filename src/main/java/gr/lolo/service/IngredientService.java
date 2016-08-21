package gr.lolo.service;

import gr.lolo.domain.Ingredient;
import gr.lolo.repository.IngredientRepository;
import gr.lolo.util.Slugifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private Slugifier slugifier;

    public Ingredient upsetIngredient(String name) {
        Optional<Ingredient> ingr = ingredientRepository.findOneByName(name);
        return ingr.orElseGet(() -> {
            Ingredient newIngr = new Ingredient();
            newIngr.setName(name);
            return ingredientRepository.save(newIngr);
        });
    }

    public void slugify(Ingredient ingredient) {
        ingredient.setSlug(slugifier.slugify(ingredient.getName()));
    }

}
