package pw.ersms.emergencies.emergency;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface EmergencyRepository extends JpaRepository<Emergency, Integer> {

    @Query("SELECT e FROM Emergency e WHERE e.id = ?1")
    Optional<Emergency> findEmergencyById(int id);

}
