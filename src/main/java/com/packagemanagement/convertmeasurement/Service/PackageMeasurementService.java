package com.packagemanagement.convertmeasurement.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service

@Slf4j
public class PackageMeasurementService {
    public ArrayList<Integer> measuredInflows = new ArrayList<>();

    /**
     * This function converts an input string that represent measurement to a list of values that of the measured inflows
     * @param input: input string which represents package measurements
     * @return Array List of the converted values
     */
    public ArrayList<Integer> getMeasuredInflows(String input) {
        measuredInflows.clear();
        for (int i = 0; i < input.length(); ++i) {
            // represents the number of parsed values
            int takenValues = 0;

            char currChar = input.charAt(i);
            // represents the needed number of values
            int neededNumOfVals = 0;

            // The following if-else with the while loop checks the count values of the measurement cycles
            if (currChar == '_') {
                neededNumOfVals = 0;
            } else {
                neededNumOfVals = (int) currChar - 96;
                if (currChar == 'z') {
                    ++i;
                    try {
                        currChar = input.charAt(i);
                    } catch (StringIndexOutOfBoundsException outOfBoundsException) {
                        log.warn("Invalid entry");
                    }
                    while (currChar == 'z') {
                        neededNumOfVals = neededNumOfVals + (int) currChar - 96;
                        ++i;
                        currChar = input.charAt(i);
                    }
                    if (currChar == '_') {

                    } else {
                        neededNumOfVals = neededNumOfVals + (int) currChar - 96;
                    }

                }
            }
            log.info("Calculated the value count");
            // represents the sum of the converted values of a measurement cycle
            int convertedValue = 0;

            // checks that the parsed values are identical to the total requested values
            while (takenValues != neededNumOfVals){
                ++i;
                try {
                    currChar = input.charAt(i);
                } catch (StringIndexOutOfBoundsException outOfBoundsException) {
                    log.warn("Invalid entry");
                }
                if(currChar == '_') {

                } else {
                    convertedValue = convertedValue + (int) currChar - 96;
                    if (currChar == 'z') {
                        ++i;
                        currChar = input.charAt(i);
                        while (currChar == 'z') {
                            convertedValue = convertedValue + (int) currChar - 96;
                            ++i;
                            currChar = input.charAt(i);
                        }
                        if (currChar == '_') {

                        } else {
                            convertedValue = convertedValue + (int) currChar - 96;
                        }
                    }
                }
                takenValues++;
            }
            measuredInflows.add(convertedValue);

        }
        log.info("Decoded the given string");
        return measuredInflows;
    }
}
