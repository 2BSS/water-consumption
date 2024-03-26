package ee.adrian.backend.Repositories;

import ee.adrian.backend.Models.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Date;

@Repository
public interface NewMeasurementRepository extends JpaRepository<Measurement, Long> {
    Optional<Measurement> findByDateAndUserId(Date date, int userId);
    Optional<Measurement> findFirstByUserIdOrderByDateDesc(int userId);
}