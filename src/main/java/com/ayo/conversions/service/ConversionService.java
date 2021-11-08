package com.ayo.conversions.service;

import com.ayo.conversions.exception.CustomException;
import com.ayo.conversions.units.Category;
import com.ayo.conversions.units.UnitDefinition;
import com.ayo.conversions.entity.UnitConvertor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import org.apache.commons.lang3.EnumUtils;

@Service
@Slf4j
/***
 * Generic Service method to validate inputs and perform the conversions
 */
public class ConversionService {

    public String convert(String unitCategory, String fromUnit, String toUnit, String value){

        Category enumCategory;
        UnitDefinition fromUnitEnumUitDefinition;
        UnitDefinition toUnitEnumUitDefinition;
        double sourceValue;
        String returnValue = "";

        //Validate the unit category
        if(!EnumUtils.isValidEnum(Category.class, unitCategory.toUpperCase())){
            log.error("INVALID UNIT CATEGORY "+unitCategory);
            throw new CustomException("INVALID UNIT CATEGORY "+unitCategory);
        }else{
            enumCategory = Category.valueOf(unitCategory.toUpperCase());
        }

        //Validate the Source unit type
        if(!EnumUtils.isValidEnum(UnitDefinition.class, fromUnit.toUpperCase())){
            log.error("INVALID FROM UNIT TYPE "+fromUnit);
            throw new CustomException("INVALID FROM UNIT TYPE "+fromUnit);
        }else{
            fromUnitEnumUitDefinition = UnitDefinition.valueOf(fromUnit.toUpperCase());
        }

        //Validate the Target unit Type
        if(!EnumUtils.isValidEnum(UnitDefinition.class, toUnit.toUpperCase())){
            log.error("INVALID TO UNIT TYPE "+toUnit);
            throw new CustomException("INVALID TO UNIT TYPE "+toUnit);
        }else{
            toUnitEnumUitDefinition = UnitDefinition.valueOf(toUnit.toUpperCase());
        }

        //Validate if the conversion is happening between units of the same category
        if(fromUnitEnumUitDefinition.UNIT.getCategory() != enumCategory || toUnitEnumUitDefinition.UNIT.getCategory() != enumCategory){
            log.error("INVALID CONVERSION FROM "+fromUnit+" TO "+toUnit);
            throw new CustomException("INVALID CONVERSION OF "+unitCategory+" FROM "+fromUnit+" TO "+toUnit);
        }

        try{
            sourceValue = Double.parseDouble(value);//Convert the input value to Double
        }catch(NullPointerException | NumberFormatException e ){
            log.error("VALUE IS EITHER NULL OR NOT A NUMBER -> "+value);
            throw new CustomException("VALUE IS EITHER NULL OR NOT A NUMBER -> "+value);
        }

        try{//To handle other unknown exceptions while conversions
            UnitConvertor unitConvertor = new UnitConvertor(enumCategory, fromUnitEnumUitDefinition);
            returnValue = unitConvertor.convertToString(sourceValue, toUnitEnumUitDefinition);
        }catch (Exception exception){
            log.error("ERROR WHILE CONVERTING VALUES -> "+ exception.getMessage());
            throw new CustomException("ERROR WHILE CONVERTING VALUES -> "+ exception.getMessage());
        }
        return returnValue;
    }

}
