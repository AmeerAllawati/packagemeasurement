package com.packagemanagement.convertmeasurement.Controller;

import com.packagemanagement.convertmeasurement.Service.PackageMeasurementService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;




@SpringBootTest
@AutoConfigureMockMvc
public class PackageMeasurementControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PackageMeasurementService packageMeasurementService;

    @Test
    public void getMeasurement() throws Exception {
        ArrayList<Integer> expectedResult = new ArrayList<>(Arrays.asList((1)));
        String input = "a";
        when(packageMeasurementService.getMeasuredInflows(anyString())).thenReturn(expectedResult);

        mockMvc.perform(get("api/pmc/convert")
                .param("input", input)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0]").value(1));

    }
}
