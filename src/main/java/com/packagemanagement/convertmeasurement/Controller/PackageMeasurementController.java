package com.packagemanagement.convertmeasurement.Controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.constraints.Pattern;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/api/pmc")
public class PackageMeasurementController {

    @Operation(
            summary = "Convert a string to measurement",
            description = "You input a string, and the request outputs an array " +
                    "list of the total values of measured inflows for each package"
    )
    @GetMapping
    public ArrayList<Integer> convertMeasurement(@RequestParam @Pattern(regexp = "^[a-z_]+$") String input) {
        // a = 97 in ascii

        return null;
    }
}
