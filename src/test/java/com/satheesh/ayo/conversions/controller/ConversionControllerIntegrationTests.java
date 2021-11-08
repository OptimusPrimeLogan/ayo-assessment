package com.satheesh.ayo.conversions.controller;

import com.satheesh.ayo.conversions.exception.CustomException;
import com.satheesh.ayo.conversions.exception.GlobalExceptionHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.hasToString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ConversionControllerIntegrationTests {

    MockMvc mockMvc;
    String resultTemperature;

    @Autowired
    ConversionController conversionController;

    @BeforeAll
    public void setup() throws Exception {
        this.mockMvc = standaloneSetup(this.conversionController).setControllerAdvice(GlobalExceptionHandler.class).build();
        resultTemperature = "274.150000 K";
    }

    @Test
    public void testTemperature() throws Exception{
        mockMvc.perform(get("/convert/temperature/celsius/kelvin/1").contentType("text/plain"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(resultTemperature));
    }


    @Test()
    public void testInvalidCategory() throws Exception{
        mockMvc.perform(get("/convert/ramp/celsius/kelvin/1").contentType("text/plain"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(result -> Assertions.assertTrue(result.getResolvedException() instanceof CustomException))
                .andExpect(jsonPath("$.errorMessage", hasToString("INVALID UNIT CATEGORY ramp")));
    }

    @Test()
    public void testInvalidFromUnit() throws Exception{
        mockMvc.perform(get("/convert/temperature/ramp/kelvin/1").contentType("text/plain"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(result -> Assertions.assertTrue(result.getResolvedException() instanceof CustomException))
                .andExpect(jsonPath("$.errorMessage", hasToString("INVALID FROM UNIT TYPE ramp")));
    }

    @Test()
    public void testInvalidToUnit() throws Exception{
        mockMvc.perform(get("/convert/temperature/celsius/ramp/1").contentType("text/plain"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(result -> Assertions.assertTrue(result.getResolvedException() instanceof CustomException))
                .andExpect(jsonPath("$.errorMessage", hasToString("INVALID TO UNIT TYPE ramp")));
    }

    @Test()
    public void testInvalidConversion() throws Exception{
        mockMvc.perform(get("/convert/temperature/celsius/miles/1").contentType("text/plain"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(result -> Assertions.assertTrue(result.getResolvedException() instanceof CustomException))
                .andExpect(jsonPath("$.errorMessage", hasToString("INVALID CONVERSION OF temperature FROM celsius TO miles")));
    }

    @Test()
    public void testInvalidvalue() throws Exception{
        mockMvc.perform(get("/convert/temperature/celsius/kelvin/a").contentType("text/plain"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(result -> Assertions.assertTrue(result.getResolvedException() instanceof CustomException))
                .andExpect(jsonPath("$.errorMessage", hasToString("VALUE IS EITHER NULL OR NOT A NUMBER -> a")));
    }

}
