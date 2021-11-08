package com.satheesh.ayo.conversions.entity;

import com.satheesh.ayo.conversions.units.Category;
import lombok.ToString;
import lombok.Getter;

import java.math.BigDecimal;

@ToString
@Getter
public class Unit {
    private final Category category;
    private final String unitShort;
    private final String unitName;
    private final BigDecimal factor;
    private final BigDecimal offset;

    public Unit(final Category CATEGORY, final String UNIT_SHORT, final String UNIT_NAME, final BigDecimal FACTOR) {
        this(CATEGORY, UNIT_SHORT, UNIT_NAME, FACTOR, new BigDecimal("0.0"));
    }

    public Unit(final Category CATEGORY, final String UNIT_SHORT, final String UNIT_NAME, final BigDecimal FACTOR_BD, final BigDecimal OFFSET_BD) {
        category = CATEGORY;
        unitShort = UNIT_SHORT;
        unitName = UNIT_NAME;
        factor = FACTOR_BD;
        offset = OFFSET_BD;
    }



}
