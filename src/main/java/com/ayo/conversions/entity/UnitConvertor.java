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

    public UnitConvertor(final Category UNIT_TYPE, final UnitDefinition SOURCE_UNIT_DEFINITION) {
        sourceUnitDefinition    = SOURCE_UNIT_DEFINITION;
        baseUnit                = BaseUnits.BASE_UNITS.get(UNIT_TYPE).UNIT;
        locale                  = Locale.UK;
        formatString            = "%.6f";
    }

    public final double convert(final double VALUE, final UnitDefinition targetUnitDefinition) {
        return ((((VALUE + sourceUnitDefinition.UNIT.getOffset().doubleValue()) * sourceUnitDefinition.UNIT.getFactor().doubleValue())
                                + baseUnit.getOffset().doubleValue())
                        * baseUnit.getFactor().doubleValue()) /
                targetUnitDefinition.UNIT.getFactor().doubleValue() - targetUnitDefinition.UNIT.getOffset().doubleValue();
    }

    public final String convertToString(final double VALUE, final UnitDefinition targetUnitDefinition) {
        return String.join(" ", String.format(locale, formatString, convert(VALUE, targetUnitDefinition)), targetUnitDefinition.UNIT.getUnitShort());
    }
}
