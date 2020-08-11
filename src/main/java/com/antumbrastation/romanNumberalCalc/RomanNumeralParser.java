package com.antumbrastation.romanNumberalCalc;

public class RomanNumeralParser {

    public static int parseRomanNumeral(String numeral) {
        char[] splitNumeral = numeral.toCharArray();
        return parseRomanNumeralHelper(splitNumeral, splitNumeral.length - 1);
    }

    private static int parseRomanNumeralHelper(char[] splitNumeral, int rightMostIndexToCount) {
        if (rightMostIndexToCount < 0) {
            return 0;
        } else if (rightMostIndexToCount == 0) {
            return RomanNumeralParser.valueOfCharacter(splitNumeral[0]);
        }

        int currentValue = RomanNumeralParser.valueOfCharacter(splitNumeral[rightMostIndexToCount]);
        int possibleSubtractionValue = RomanNumeralParser.valueOfCharacter(splitNumeral[rightMostIndexToCount - 1]);

        if (currentValue <= possibleSubtractionValue) {
            return currentValue + parseRomanNumeralHelper(splitNumeral, rightMostIndexToCount - 1);
        } else {
            return (currentValue - possibleSubtractionValue) + parseRomanNumeralHelper(splitNumeral, rightMostIndexToCount - 2);
        }
    }

    private static int valueOfCharacter(char character) {
        switch (character) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0; // TODO - need to inquire on better error handling logic, none specified in spec
        }
    }
}
