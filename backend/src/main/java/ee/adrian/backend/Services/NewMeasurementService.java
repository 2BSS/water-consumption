package ee.adrian.backend.Services;

import ee.adrian.backend.Models.NewMeasurement;
import ee.adrian.backend.Repositories.NewMeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewMeasurementService {

    @Autowired
    private NewMeasurementRepository newMeasurementRepository;

    public void createNewMeasurement(NewMeasurement newMeasurement) {
        newMeasurementRepository.save(newMeasurement);
    }
}
