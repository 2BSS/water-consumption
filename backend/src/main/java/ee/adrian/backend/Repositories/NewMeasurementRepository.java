package ee.adrian.backend.Repositories;

import ee.adrian.backend.Models.NewMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Date;

@Repository
public interface NewMeasurementRepository extends JpaRepository<NewMeasurement, Long> {
    Optional<NewMeasurement> findByDateAndUserId(Date date, int userId);
}