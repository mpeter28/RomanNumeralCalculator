package com.antumbrastation.romanNumberalCalc;

public class CalculatorGrammar {

    public static String[] lexProgramIntoTokens(String calculatorProgram) {
        return calculatorProgram.split(" +");
    }

    public static String[] replaceRomanTokensWithArabicTokens(String[] programTokens) {
        for (int tokenIndex = 0; tokenIndex < programTokens.length; tokenIndex++) {
            switch (programTokens[tokenIndex]) {
                case "(":
                case ")":
                case "+":
                case "-":
                case "*":
                case "/":
                    break;
                default:
                    programTokens[tokenIndex] = String.valueOf(RomanNumeralParser.parseRomanNumeral(programTokens[tokenIndex]));
            }
        }

        return programTokens;
    }

    public static double evalCalculatorProgram(String[] programTokens) {
        if (programTokens.length == 0) {
            return 0;
        }

        return 0;
    }
}
