package com.satheesh.ayo.conversions.service;

import com.satheesh.ayo.conversions.exception.CustomException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ConversionServiceTests {

    @Autowired
    ConversionService conversionService;

    @Test
    public void testTemperature() throws Exception{

        String resultTemperature = conversionService.convert("temperature",
                "celsius", "kelvin", "1");

        assertThat(resultTemperature).isNotNull()
                .isNotEmpty().isEqualTo(resultTemperature);

    }

    @Test
    public void testInvalidCategory() throws Exception{
        Exception exception = Assertions.assertThrows(
                CustomException.class, () -> {
                    conversionService.convert("ramp", "celsius", "kelvin", "1");
                });

       assertThat(exception.getMessage().equals("INVALID UNIT CATEGORY ramp"));
    }

    @Test
    public void testInvalidFromUnit() throws Exception{
        Exception exception = Assertions.assertThrows(
                CustomException.class, () -> {
                    conversionService.convert("temperature", "ramp", "kelvin", "1");
                });

        assertThat(exception.getMessage().equals("INVALID FROM UNIT TYPE ramp"));
    }

    @Test
    public void testInvalidToUnit() throws Exception{
        Exception exception = Assertions.assertThrows(
                CustomException.class, () -> {
                    conversionService.convert("temperature", "celsius", "ramp", "1");
                });

        assertThat(exception.getMessage().equals("INVALID TO UNIT TYPE ramp"));
    }

    @Test
    public void testInvalidConversion() throws Exception{
        Exception exception = Assertions.assertThrows(
                CustomException.class, () -> {
                    conversionService.convert("temperature", "celsius", "miles", "1");
                });

        assertThat(exception.getMessage().equals("INVALID CONVERSION FROM celsius TO miles"));
    }

    @Test
    public void testInvalidvalue() throws Exception{
        Exception exception = Assertions.assertThrows(
                CustomException.class, () -> {
                    conversionService.convert("temperature", "celsius", "kelvin", "a");
                });

        assertThat(exception.getMessage().equals("VALUE IS EITHER NULL OR NOT A NUMBER -> a"));
    }
}
