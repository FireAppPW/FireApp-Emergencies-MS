package pw.ersms.emergencies.classification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassificationRepository extends JpaRepository<Classification, Integer> {

    @Query("SELECT c FROM Classification c WHERE c.id = ?1")
    Optional<Classification> findClassificationById(int id);
}
