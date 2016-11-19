package gr.lolo.repository;

import gr.lolo.domain.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UnitRepository extends JpaRepository<Unit, String> {

    Optional<Unit> findOneBySlug(String slug);
    Optional<Unit> findOneByName(String name);
}
