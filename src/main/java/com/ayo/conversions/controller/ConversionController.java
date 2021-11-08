package com.ayo.conversions.controller;

import com.ayo.conversions.service.ConversionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/convert")
@Slf4j
/***
 * Generic Controller class to perform unit conversions
 */
public class ConversionController {

    @Autowired
    private ConversionService conversionService;


    /**
     * Generic method to perform the conversion
     * @param unitCategory Category of the UNIT (e.g., SPEED, TEMPERATURE)
     * @param fromUnit Source unit name (E.g., CELSIUS)
     * @param toUnit Target unit name (E.g., CELSIUS)
     * @param value Value to be converted
     * @return Converted value or throws exception if there are invalid values, handled by GlobalExceptionHandler.
     */
    @GetMapping("/{unitCategory}/{fromUnit}/{toUnit}/{value}")
    private ResponseEntity convert(@PathVariable String unitCategory, @PathVariable String fromUnit,
                                   @PathVariable String toUnit, @PathVariable String value){
        log.info(unitCategory+" conversion of "+value+" from "+fromUnit+" to "+toUnit);
        return new ResponseEntity(conversionService.convert(unitCategory, fromUnit, toUnit, value), HttpStatus.OK);
    }
}
