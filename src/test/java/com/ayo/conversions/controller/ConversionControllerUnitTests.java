package com.ayo.conversions.controller;

import com.ayo.conversions.service.ConversionService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ConversionControllerUnitTests {

    private MockMvc mockMvc;
    private String resultTemperature;

    @Autowired
    ConversionController conversionController;

    @MockBean
    ConversionService conversionService;

    @BeforeAll
    public void setup() throws Exception {
        this.mockMvc = standaloneSetup(this.conversionController).build();
        resultTemperature = "274.150000 K";
    }

    @Test
    public void testTemperature() throws Exception{
        // Mocking service
        when(conversionService.convert(any(String.class), any(String.class), any(String.class), any(String.class))).thenReturn(resultTemperature);

        mockMvc.perform(get("/convert/temperature/celsius/kelvin/1").contentType("text/plain"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(resultTemperature));
    }

}
