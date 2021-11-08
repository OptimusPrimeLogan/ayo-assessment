package com.satheesh.ayo.conversions.entity;

import com.satheesh.ayo.conversions.units.BaseUnits;
import com.satheesh.ayo.conversions.units.Category;
import com.satheesh.ayo.conversions.units.UnitDefinition;

import java.util.Locale;

public class UnitConvertor {
    private final UnitDefinition baseUnitDefinition;
    private final Unit bean;
    private final Locale locale;
    private final String formatString;

    public UnitConvertor(final Category UNIT_TYPE, final UnitDefinition BASE_UNIT_DEFINITION) {
        baseUnitDefinition = BASE_UNIT_DEFINITION;
        bean               = BaseUnits.BASE_UNITS.get(UNIT_TYPE).UNIT;
        locale             = Locale.US;
        formatString       = "%.2f";
    }

    public final double convert(final double VALUE, final UnitDefinition UNIT_DEFINITION) {
        return ((((VALUE + baseUnitDefinition.UNIT.getOffset().doubleValue())
                * baseUnitDefinition.UNIT.getFactor().doubleValue()) + bean.getOffset().doubleValue())
                * bean.getFactor().doubleValue()) / UNIT_DEFINITION.UNIT.getFactor().doubleValue() - UNIT_DEFINITION.UNIT.getOffset().doubleValue();
    }

    public final String convertToString(final double VALUE, final UnitDefinition UNIT_DEFINITION) {
        return String.join(" ", String.format(locale, formatString, convert(VALUE, UNIT_DEFINITION)), UNIT_DEFINITION.UNIT.getUnitShort());
    }
}
