package com.packagemanagement.convertmeasurement.Controller;

import com.packagemanagement.convertmeasurement.Service.PackageMeasurementService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.constraints.Pattern;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.regex.PatternSyntaxException;

@RestController
@RequestMapping(path = "/api/pmc")
@Slf4j
public class PackageMeasurementController {

    @ExceptionHandler(PatternSyntaxException.class)
    public void handlePatternSyntaxException(PatternSyntaxException e) {
        log.warn(e.getMessage());
    }
    @Operation(
            summary = "Convert a string to measurement",
            description = "You input a string, and the request outputs an array " +
                    "list of the total values of measured inflows for each package"
    )
    @GetMapping("/convert")
    public ArrayList<Integer> convertMeasurement(@RequestParam @Pattern(regexp = "^[a-z_]+$") String input) {
        // a = 97 in ascii

        return pms.getMeasuredInflows(input);
    }

    @Autowired
    private PackageMeasurementService pms;
}
