package com.satheesh.ayo.conversions.units;

import com.satheesh.ayo.conversions.entity.Unit;

import java.math.BigDecimal;

public enum UnitDefinition {

    // Length
    KILOMETER(new Unit(Category.LENGTH, "km", "Kilometer", new BigDecimal("1000.0"))),
    HECTOMETER(new Unit(Category.LENGTH, "hm", "Hectometer", new BigDecimal("100"))),
    METER(new Unit(Category.LENGTH, "m", "Meter", new BigDecimal("1.0"))),
    DECIMETER(new Unit(Category.LENGTH, "dm", "Decimeter", new BigDecimal("0.1"))),
    CENTIMETER(new Unit(Category.LENGTH, "cm", "Centimeter", new BigDecimal("0.01"))),
    MILLIMETER(new Unit(Category.LENGTH, "mm", "Millimeter", new BigDecimal("0.0010"))),
    MICROMETER(new Unit(Category.LENGTH, "\u00b5m", "Micrometer", new BigDecimal("1.0E-6"))),
    NANOMETER(new Unit(Category.LENGTH, "nm", "Nanometer", new BigDecimal("1.0E-9"))),
    ANGSTROM(new Unit(Category.LENGTH, "\u00c5", "Angstrom", new BigDecimal("1.0E-10"))),
    PICOMETER(new Unit(Category.LENGTH, "pm", "Picometer", new BigDecimal("1.0E-12"))),
    FEMTOMETER(new Unit(Category.LENGTH, "fm", "Femtometer", new BigDecimal("1.0E-15"))),
    INCHES(new Unit(Category.LENGTH, "in", "Inches", new BigDecimal("0.0254"))),
    MILES(new Unit(Category.LENGTH, "mi", "Miles", new BigDecimal("1609.344"))),
    NAUTICAL_MILES(new Unit(Category.LENGTH, "nmi", "Nautical Miles", new BigDecimal("1852.0"))),
    FEET(new Unit(Category.LENGTH, "ft", "Feet", new BigDecimal("0.3048"))),
    YARD(new Unit(Category.LENGTH, "yd", "Yard", new BigDecimal("0.9144"))),
    LIGHT_YEAR(new Unit(Category.LENGTH, "l.y.", "Light-Year", new BigDecimal("9.46073E15"))),

    // Mass
    TON(new Unit(Category.MASS, "t", "Ton", new BigDecimal("1.0E3"))),
    KILOGRAM(new Unit(Category.MASS, "kg", "Kilogram", new BigDecimal("1.0"))),
    GRAM(new Unit(Category.MASS, "g", "Gram", new BigDecimal("1.0E-3"))),
    MILLIGRAM(new Unit(Category.MASS, "mg", "Milligram", new BigDecimal("1.0E-6"))),
    MICROGRAM(new Unit(Category.MASS, "\u00b5g", "Mikrogram", new BigDecimal("1.0E-6"))),
    NANOGRAM(new Unit(Category.MASS, "ng", "Nanogram", new BigDecimal("1.0E-9"))),
    PICOGRAM(new Unit(Category.MASS, "pg", "Picogram", new BigDecimal("1.0E-12"))),
    FEMTOGRAM(new Unit(Category.MASS, "fg", "Femtogram", new BigDecimal("1.0E-15"))),
    OUNCE(new Unit(Category.MASS, "oz", "Ounce (US)", new BigDecimal("0.028"))),
    POUND(new Unit(Category.MASS, "lb", "Pounds (US)", new BigDecimal("0.45359237"))),

    // Time
    WEEK(new Unit(Category.TIME, "wk", "Week", new BigDecimal("604800"))),
    DAY(new Unit(Category.TIME, "d", "Day", new BigDecimal("86400"))),
    HOUR(new Unit(Category.TIME, "h", "Hour", new BigDecimal("3600"))),
    MINUTE(new Unit(Category.TIME, "m", "Minute", new BigDecimal("60"))),
    SECOND(new Unit(Category.TIME, "s", "Second", new BigDecimal("1.0"))),
    MILLISECOND(new Unit(Category.TIME, "ms", "Millisecond", new BigDecimal("1E-3"))),
    MICROSECOND(new Unit(Category.TIME, "\u00b5s", "Microsecond", new BigDecimal("1E-6"))),
    NANOSECOND(new Unit(Category.TIME, "ns", "Nanosecond", new BigDecimal("1E-9"))),

    // Temperature
    KELVIN(new Unit(Category.TEMPERATURE, "K", "Kelvin", new BigDecimal("1.0"))),
    CELSIUS(new Unit(Category.TEMPERATURE, "\u00b0C", "Celsius", new BigDecimal("1.0"), new BigDecimal("273.15"))),
    FAHRENHEIT(new Unit(Category.TEMPERATURE, "\u00b0F", "Fahrenheit", new BigDecimal("0.555555555555555"), new BigDecimal("459.67"))),

    // Volume
    CUBIC_MILLIMETER(new Unit(Category.VOLUME, "mm\u00b3", "Cubic Millimeter", new BigDecimal("1.0E-9"))),
    MILLILITER(new Unit(Category.VOLUME, "ml", "Milliliter", new BigDecimal("1.0E-6"))),
    LITER(new Unit(Category.VOLUME, "l", "Liter", new BigDecimal("1.0E-3"))),
    CUBIC_METER(new Unit(Category.VOLUME, "m\u00b3", "Cubic Meter", new BigDecimal("1.0E0"))),
    GALLON(new Unit(Category.VOLUME, "gal", "US Gallon", new BigDecimal("0.0037854118"))),
    CUBIC_FEET(new Unit(Category.VOLUME, "ft\u00b3", "Cubic Foot", new BigDecimal("0.0283168466"))),
    CUBIC_INCH(new Unit(Category.VOLUME, "in\u00b3", "Cubic Inch", new BigDecimal("0.0000163871"))),

    // Speed
    MILLIMETER_PER_SECOND(new Unit(Category.SPEED, "mm/s", "Millimeter per second", new BigDecimal("1.0E-3"))),
    METER_PER_SECOND(new Unit(Category.SPEED, "m/s", "Meter per second", new BigDecimal("1.0E0"))),
    KILOMETER_PER_HOUR(new Unit(Category.SPEED, "km/h", "Kilometer per hour", new BigDecimal("0.2777777778"))),
    MILES_PER_HOUR(new Unit(Category.SPEED, "mph", "Miles per hour", new BigDecimal("0.4472271914"))),
    KNOT(new Unit(Category.SPEED, "kt", "Knot", new BigDecimal("0.51444444444444"))),
    MACH(new Unit(Category.SPEED, "M", "Mach", new BigDecimal("0.00293866995797")));

    public final Unit UNIT;

    UnitDefinition(final Unit UNIT) {
        this.UNIT = UNIT;
    }
}
