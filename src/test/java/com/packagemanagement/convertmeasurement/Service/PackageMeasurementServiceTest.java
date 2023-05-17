package com.packagemanagement.convertmeasurement.Service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootTest
public class PackageMeasurementServiceTest {


    private PackageMeasurementService pmc = new PackageMeasurementService();
    @Test
    public void testConvertMethod1() {
        String input = "aa";

        ArrayList<Integer> result = pmc.getMeasuredInflows(input);
        assertEquals(result.get(0), 1);
    }

    @Test
    public void testConvertMethod2() {
        String input = "abbcc";

        ArrayList<Integer> result = pmc.getMeasuredInflows(input);
        assertEquals(result.get(0), 2);
        assertEquals(result.get(1), 6);
    }

    @Test
    public void testConvertMethod3() {
        String input = "dz_a_aazzaaa";

        ArrayList<Integer> result = pmc.getMeasuredInflows(input);
        assertEquals(result.get(0), 28);
        assertEquals(result.get(1), 53);
        assertEquals(result.get(2), 1);
    }

    @Test
    public void testConvertMethod4() {
        String input = "";

        ArrayList<Integer> result = pmc.getMeasuredInflows(input);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testConvertMethod5() {
        String input = "a_";

        ArrayList<Integer> result = pmc.getMeasuredInflows(input);
        assertEquals(result.get(0), 0);
    }

    @Test
    public void testConvertMethod6() {
        String input = "abcdabcdab";

        ArrayList<Integer> result = pmc.getMeasuredInflows(input);
        assertEquals(result.get(0), 2);
        assertEquals(result.get(1), 7);
        assertEquals(result.get(2), 7);
    }

    @Test
    public void testConvertMethod7() {
        String input = "abcdabcdab_";

        ArrayList<Integer> result = pmc.getMeasuredInflows(input);
        assertEquals(result.get(0), 2);
        assertEquals(result.get(1), 7);
        assertEquals(result.get(2), 7);
        assertEquals(result.get(3), 0);
    }

    @Test
    public void testConvertMethod8() {
        String input = "zdaaaaaaaabaaaaaaaabaaaaaaaabbaa";

        ArrayList<Integer> result = pmc.getMeasuredInflows(input);
        assertEquals(result.get(0), 34);
    }

    @Test
    public void testConvertMethod9() {
        String input = "zza_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_a_";

        ArrayList<Integer> result = pmc.getMeasuredInflows(input);
        assertEquals(result.get(0), 26);
    }

    @Test
    public void testConvertMethod10() {
        String input = "za_a_a_a_a_a_a_a_a_a_a_a_a_azaaa";

        ArrayList<Integer> result = pmc.getMeasuredInflows(input);
        assertEquals(result.get(0), 40);
        assertEquals(result.get(1), 1);
    }

}
