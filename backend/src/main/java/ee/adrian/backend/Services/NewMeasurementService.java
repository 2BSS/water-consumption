package ee.adrian.backend.Services;

import ee.adrian.backend.Models.NewMeasurement;
import ee.adrian.backend.Repositories.NewMeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NewMeasurementService {

    @Autowired
    private NewMeasurementRepository newMeasurementRepository;

    public boolean createNewMeasurement(NewMeasurement newMeasurement) {
        // Check if a measurement with the same date already exists
        Optional<NewMeasurement> existingMeasurement = newMeasurementRepository.findByDateAndUserId(newMeasurement.getDate(), newMeasurement.getUserId());

        if (existingMeasurement.isPresent()) {
            // Update existing measurement with new values
            NewMeasurement existing = existingMeasurement.get();
            existing.setKitchenHot(newMeasurement.getKitchenHot());
            existing.setKitchenCold(newMeasurement.getKitchenCold());
            existing.setBathroomHot(newMeasurement.getBathroomHot());
            existing.setBathroomCold(newMeasurement.getBathroomCold());
            // Save the updated measurement
            newMeasurementRepository.save(existing);
            return true;
        } else {
            // If no measurement with the same date exists, save the new measurement
            newMeasurementRepository.save(newMeasurement);
            return false;
        }
    }
}
