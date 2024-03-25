package ee.adrian.backend.Repositories;

import ee.adrian.backend.Models.NewMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewMeasurementRepository extends JpaRepository<NewMeasurement, Long> {
}