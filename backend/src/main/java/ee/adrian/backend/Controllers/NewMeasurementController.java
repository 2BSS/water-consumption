package ee.adrian.backend.Controllers;

import ee.adrian.backend.Models.NewMeasurement;
import ee.adrian.backend.Services.NewMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewMeasurementController {

    @Autowired
    private NewMeasurementService newMeasurementService;

    @PostMapping("/new-measurement")
    public void createNewMeasurement(@RequestBody NewMeasurement newMeasurement) {
        newMeasurementService.createNewMeasurement(newMeasurement);
    }
}