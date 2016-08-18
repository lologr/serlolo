package gr.lolo.repository;

import gr.lolo.domain.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    @Query("select i from ingredient i where i.name like :name%")
    List<Ingredient> startsWith(@Param("name") String name);

}
