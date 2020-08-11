package com.antumbrastation.romanNumberalCalc;

import org.junit.Assert;
import org.junit.Test;

public class TestRomanNumeralParser {

    @Test
    public void testBasicAllCharacters() {
        Assert.assertEquals(1667, RomanNumeralParser.parseRomanNumeral("MDCLXVII"));
    }

    @Test
    public void testSubtractivePrefixes() {
        Assert.assertEquals(4, RomanNumeralParser.parseRomanNumeral("IV"));

        Assert.assertEquals(40, RomanNumeralParser.parseRomanNumeral("XL"));

        Assert.assertEquals(14, RomanNumeralParser.parseRomanNumeral("XIV"));

        Assert.assertEquals(90, RomanNumeralParser.parseRomanNumeral("XC"));

        Assert.assertEquals(519, RomanNumeralParser.parseRomanNumeral("DXIX"));

        Assert.assertEquals(900, RomanNumeralParser.parseRomanNumeral("CM"));

        Assert.assertEquals(954, RomanNumeralParser.parseRomanNumeral("CMVLIX"));
    }

    @Test
    public void testGibberishCharacterEqualsZero() {
        Assert.assertEquals(0, RomanNumeralParser.parseRomanNumeral("g"));
    }

    @Test
    public void confirmBehaviorOfSomePseudoLegalCases() {
        Assert.assertEquals(6, RomanNumeralParser.parseRomanNumeral("IVX"));
    }
}
