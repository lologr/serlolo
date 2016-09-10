package gr.lolo.service;

import gr.lolo.converter.IngredientConverter;
import gr.lolo.domain.Ingredient;
import gr.lolo.repository.IngredientRepository;
import gr.lolo.resource.IngredientResource;
import gr.lolo.util.Slugifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private Slugifier slugifier;

    @Autowired
    private IngredientConverter ingredientConverter;

    public Ingredient upsertIngredient(Ingredient ingredient) {
        return upsertIngredient(ingredient.getIngredient());
    }

    public Ingredient upsertIngredient(String name) {
        return ingredientRepository.save(createIngredient(name));
    }

    public Ingredient createIngredient(String name) {
        Optional<Ingredient> ingr = ingredientRepository.findOneByIngredient(name);
        return ingr.orElseGet(() -> {
            Ingredient newIngr = new Ingredient();
            newIngr.setIngredient(name);
            newIngr.setSlug(slugifier.slugify(name));
            return newIngr;
        });
    }

    public List<IngredientResource> getResourceSortedByNumberOfRecipes(List<Ingredient> ingredients, int limit) {
//        return ingredients.stream()
//                .sorted((o1, o2) -> -Integer.compare(o1.getRecipes().size(), o2.getRecipes().size()))
//                .limit(limit)
//                .map(ingredientConverter::convert)
//                .collect(Collectors.toList());
        return null;
    }

}
