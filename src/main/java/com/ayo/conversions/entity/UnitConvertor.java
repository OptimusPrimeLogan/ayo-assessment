package com.ayo.conversions.entity;

import com.ayo.conversions.units.BaseUnits;
import com.ayo.conversions.units.Category;
import com.ayo.conversions.units.UnitDefinition;

import java.util.Locale;

/***
 * UTILITY/ENTITY class to setup the convertor object and perform the conversions.
 */
public class UnitConvertor {
    private final UnitDefinition sourceUnitDefinition;
    private final Unit baseUnit;
    private final Locale locale;
    private final String formatString;

    /**
     * Parameterised constructor to setup source and base
     * @param UNIT_TYPE Category
     * @param SOURCE_UNIT_DEFINITION Source Unit Data
     */
    public UnitConvertor(final Category UNIT_TYPE, final UnitDefinition SOURCE_UNIT_DEFINITION) {
        sourceUnitDefinition    = SOURCE_UNIT_DEFINITION;
        baseUnit                = BaseUnits.BASE_UNITS.get(UNIT_TYPE).UNIT;
        locale                  = Locale.UK;
        formatString            = "%.6f";
    }

    /**
     * Method to convert the provided value to target unit type
     * The basis of the formula is to convert the source value to base unit first and then convert the calculated base unit to target unit
     * Eg., For a celsius to fahrenheit conversion, Celsius -> Kelvin -> Fahrenheit
     * [K] = [°C] + 273.15 and then [°F] = [K] × 9⁄5 − 459.67
     * @param VALUE Source value
     * @param targetUnitDefinition Target Unit Data
     * @return converted value in double format
     */
    public final double convert(final double VALUE, final UnitDefinition targetUnitDefinition) {
        return ((((VALUE + sourceUnitDefinition.UNIT.getOffset().doubleValue()) * sourceUnitDefinition.UNIT.getFactor().doubleValue())
                                + baseUnit.getOffset().doubleValue())
                        * baseUnit.getFactor().doubleValue()) /
                targetUnitDefinition.UNIT.getFactor().doubleValue() - targetUnitDefinition.UNIT.getOffset().doubleValue();
    }

    /**
     *
     * @param VALUE Source value
     * @param targetUnitDefinition Target Unit Data
     * @return converted value in formatted string with provided locale
     */
    public final String convertToString(final double VALUE, final UnitDefinition targetUnitDefinition) {
        return String.join(" ", String.format(locale, formatString, convert(VALUE, targetUnitDefinition)), targetUnitDefinition.UNIT.getUnitShort());
    }
}
