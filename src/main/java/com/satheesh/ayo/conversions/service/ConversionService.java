package com.satheesh.ayo.conversions.service;

import com.satheesh.ayo.conversions.entity.UnitConvertor;
import com.satheesh.ayo.conversions.exception.CustomException;
import com.satheesh.ayo.conversions.units.Category;
import com.satheesh.ayo.conversions.units.UnitDefinition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import org.apache.commons.lang3.EnumUtils;

@Service
@Slf4j
public class ConversionService {

    public String convert(String unitCategory, String fromUnit, String toUnit, String value){

        Category enumCategory;
        UnitDefinition fromUnitEnumUitDefinition;
        UnitDefinition toUnitEnumUitDefinition;
        double sourceValue;

        if(!EnumUtils.isValidEnum(Category.class, unitCategory.toUpperCase())){
            log.error("INVALID UNIT CATEGORY "+unitCategory);
            throw new CustomException("INVALID UNIT CATEGORY "+unitCategory);
        }else{
            enumCategory = Category.valueOf(unitCategory.toUpperCase());
        }

        if(!EnumUtils.isValidEnum(UnitDefinition.class, fromUnit.toUpperCase())){
            log.error("INVALID FROM UNIT TYPE "+fromUnit);
            throw new CustomException("INVALID FROM UNIT TYPE "+fromUnit);
        }else{
            fromUnitEnumUitDefinition = UnitDefinition.valueOf(fromUnit.toUpperCase());
        }

        if(!EnumUtils.isValidEnum(UnitDefinition.class, toUnit.toUpperCase())){
            log.error("INVALID TO UNIT TYPE "+toUnit);
            throw new CustomException("INVALID TO UNIT TYPE "+toUnit);
        }else{
            toUnitEnumUitDefinition = UnitDefinition.valueOf(toUnit.toUpperCase());
        }

        if(fromUnitEnumUitDefinition.UNIT.getCategory() != enumCategory || toUnitEnumUitDefinition.UNIT.getCategory() != enumCategory){
            log.error("INVALID CONVERSION FROM "+fromUnit+" TO "+toUnit);
            throw new CustomException("INVALID CONVERSION OF "+unitCategory+" FROM "+fromUnit+" TO "+toUnit);
        }

        try{
            sourceValue = Double.parseDouble(value);
        }catch(NullPointerException | NumberFormatException e ){
            log.error("VALUE IS EITHER NULL OR NOT A NUMBER -> "+value);
            throw new CustomException("VALUE IS EITHER NULL OR NOT A NUMBER -> "+value);
        }

        UnitConvertor unitConvertor = new UnitConvertor(enumCategory, fromUnitEnumUitDefinition);
        return unitConvertor.convertToString(sourceValue, toUnitEnumUitDefinition);
    }

}
