package ee.adrian.backend.Controllers;

import ee.adrian.backend.Models.NewMeasurement;
import ee.adrian.backend.Services.NewMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
public class NewMeasurementController {

    @Autowired
    private NewMeasurementService newMeasurementService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/new-measurement")
    public ResponseEntity<String> createNewMeasurement(@RequestBody NewMeasurement newMeasurement) {
        boolean isUpdated = newMeasurementService.createNewMeasurement(newMeasurement);

        if (isUpdated) {
            return ResponseEntity.ok("Measurement was updated");
        } else {
            return ResponseEntity.ok("Measurement was added");
        }
    }
}