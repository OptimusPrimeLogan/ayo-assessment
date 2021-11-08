package com.satheesh.ayo.conversions.controller;

import com.satheesh.ayo.conversions.service.ConversionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/convert")
@Slf4j
public class ConversionController {

    @Autowired
    private ConversionService conversionService;

    @GetMapping("/{unitCategory}/{fromUnit}/{toUnit}/{value}")
    private ResponseEntity convert(@PathVariable String unitCategory, @PathVariable String fromUnit,
                                   @PathVariable String toUnit, @PathVariable String value){
        log.info(unitCategory+" conversion of "+value+" from "+fromUnit+" to "+toUnit);
        return new ResponseEntity(conversionService.convert(unitCategory, fromUnit, toUnit, value), HttpStatus.OK);
    }
}
