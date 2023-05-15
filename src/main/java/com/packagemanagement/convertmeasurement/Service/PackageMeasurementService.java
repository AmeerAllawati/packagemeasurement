package com.packagemanagement.convertmeasurement.Service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class PackageMeasurementService {
    public ArrayList<Integer> measuredInflows = new ArrayList<>();

    public ArrayList<Integer> getMeasuredInflows(String input) {


        return measuredInflows;
    }
}
