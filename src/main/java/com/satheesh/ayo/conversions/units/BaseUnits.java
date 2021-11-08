package com.satheesh.ayo.conversions.units;

import java.util.EnumMap;

public class BaseUnits {
    public static final EnumMap<Category, UnitDefinition> BASE_UNITS  = new EnumMap<Category, UnitDefinition>(Category.class) {
        {
            put(Category.LENGTH, UnitDefinition.METER);
            put(Category.MASS, UnitDefinition.KILOGRAM);
            put(Category.TIME, UnitDefinition.SECOND);
            put(Category.SPEED, UnitDefinition.METER_PER_SECOND);
            put(Category.TEMPERATURE, UnitDefinition.KELVIN);
            put(Category.VOLUME, UnitDefinition.CUBIC_METER);
        }
    };

}
