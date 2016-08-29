package gr.lolo.repository;

import gr.lolo.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    Optional<Recipe> findOneByTitle(String title);
    Optional<Recipe> findOneBySlug(String slug);
}
