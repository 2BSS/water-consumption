package ee.adrian.backend.Controllers;

import ee.adrian.backend.Models.Measurement;
import ee.adrian.backend.Services.NewMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Map;

@RestController
public class NewMeasurementController {

    @Autowired
    private NewMeasurementService newMeasurementService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/new-measurement")
    public ResponseEntity<String> createNewMeasurement(@RequestBody Measurement newMeasurement) {
        Map<String, Object> error = newMeasurementService.createNewMeasurement(newMeasurement);
        return ResponseEntity.ok(error.toString());

    }
}