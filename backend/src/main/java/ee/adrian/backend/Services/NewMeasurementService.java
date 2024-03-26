package ee.adrian.backend.Services;

import ee.adrian.backend.Models.Measurement;
import ee.adrian.backend.Repositories.NewMeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.HashMap;
import java.util.Map;

@Service
public class NewMeasurementService {

    @Autowired
    private NewMeasurementRepository newMeasurementRepository;

    public Map<String, Object> createNewMeasurement(Measurement newMeasurement) {
        // Check if a measurement with the same date and user_id already exists
        Optional<Measurement> existingMeasurement = newMeasurementRepository.findByDateAndUserId(newMeasurement.getDate(), newMeasurement.getUserId());

        // Check if there is any data previous to the submitted data
        Optional<Measurement> previousMeasurement = newMeasurementRepository.findFirstByUserIdOrderByDateDesc(newMeasurement.getUserId());

        Map<String, Object> response = new HashMap<>();


        // If current is bigger than previous
        if (previousMeasurement.isPresent()) {
            if (existingMeasurement.isPresent()) {
                response.put("error", "Measurement already exists");
                response.put("difference", createMeasurementMap(calculateMeasurementDifference(newMeasurement, previousMeasurement.get())));
                //return "Measurement already exists, difference is x";
            } else {
                if (isBiggerOrEqualThanPrevious(newMeasurement, previousMeasurement.get())) {
                    newMeasurementRepository.save(newMeasurement);
                    response.put("error", "New data entered");
                    response.put("difference", createMeasurementMap(calculateMeasurementDifference(newMeasurement, previousMeasurement.get())));
                    //return "New data entered, difference is x";
                } else {
                    response.put("error", "New measurement must be bigger than previous");
                    response.put("difference", createMeasurementMap(calculateMeasurementDifference(newMeasurement, previousMeasurement.get())));
                }
            }
        } else {
            if (existingMeasurement.isPresent()) {
                response.put("error", "Measurement for this period already exists");
                response.put("total", createMeasurementMap(newMeasurement));
                //return "First time measured, total is x";
            } else {
                    newMeasurementRepository.save(newMeasurement);
                    response.put("error", "First time measured");
                    response.put("total", createMeasurementMap(newMeasurement));
                    //return "Measurement for this period already exists, total is x";
            }

        }
        return response;

    }

    private boolean isBiggerOrEqualThanPrevious(Measurement newMeasurement, Measurement previousMeasurement){
        return newMeasurement.getBathroomCold().compareTo(previousMeasurement.getBathroomCold()) >= 0 &&
                newMeasurement.getBathroomHot().compareTo(previousMeasurement.getBathroomHot()) >= 0 &&
                newMeasurement.getKitchenCold().compareTo(previousMeasurement.getKitchenCold()) >= 0 &&
                newMeasurement.getKitchenHot().compareTo(previousMeasurement.getKitchenHot()) >= 0;
    }


    private Map<String, BigDecimal> createMeasurementMap(Measurement responseMeasurement) {
        Map<String, BigDecimal> measurementMap = new HashMap<>();
        measurementMap.put("kitchenCold", responseMeasurement.getKitchenCold());
        measurementMap.put("kitchenHot", responseMeasurement.getKitchenHot());
        measurementMap.put("bathroomCold", responseMeasurement.getBathroomCold());
        measurementMap.put("bathroomHot", responseMeasurement.getBathroomHot());
        return measurementMap;
    }

    private Measurement calculateMeasurementDifference(Measurement newMeasurement, Measurement previousMeasurement) {
        // Create a copy of the new measurement
        Measurement resultMeasurement = new Measurement();
        resultMeasurement.setUserId(newMeasurement.getUserId());
        resultMeasurement.setDate(newMeasurement.getDate());
        // Substract previous measurements from new measurements
        resultMeasurement.setKitchenHot(newMeasurement.getKitchenHot().subtract(previousMeasurement.getKitchenHot()));
        resultMeasurement.setKitchenCold(newMeasurement.getKitchenCold().subtract(previousMeasurement.getKitchenCold()));
        resultMeasurement.setBathroomHot(newMeasurement.getBathroomHot().subtract(previousMeasurement.getBathroomHot()));
        resultMeasurement.setBathroomCold(newMeasurement.getBathroomCold().subtract(previousMeasurement.getBathroomCold()));

        return resultMeasurement;
    }
}
