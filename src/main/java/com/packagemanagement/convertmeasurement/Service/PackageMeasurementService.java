package com.packagemanagement.convertmeasurement.Service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class PackageMeasurementService {
    public ArrayList<Integer> measuredInflows = new ArrayList<>();

    public ArrayList<Integer> getMeasuredInflows(String input) {
        for (int i = 0; i < input.length(); ++i) {
            int takenValues = 0;
            char currChar = input.charAt(i);
            int neededNumOfVals = 0;
            if (currChar == '_') {
                neededNumOfVals = 0;
            } else {
                neededNumOfVals = (int) currChar - 96;
                if (currChar == 'z') {
                    ++i;
                    currChar = input.charAt(i);
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
            int convertedValue = 0;
            while (takenValues != neededNumOfVals){
                ++i;
                currChar = input.charAt(i);
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
        return measuredInflows;
    }
}
