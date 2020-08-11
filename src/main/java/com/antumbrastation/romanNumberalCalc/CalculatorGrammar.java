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

        int openingParenIndex = -1;
        int closingParenIndex = -1;
        for (int tokenIndex = 0; tokenIndex < programTokens.length; tokenIndex++) {
            if (programTokens[tokenIndex].equals("(")) {
                openingParenIndex = tokenIndex;
            } else if (programTokens[tokenIndex].equals(")")) {
                closingParenIndex = tokenIndex;
                break;
            }
        }

        if (openingParenIndex >= 0 && closingParenIndex >= 0) {
           // double evaluateSubExpression = evalCalculatorProgram();
        }

        return 0;
    }

    public static String[] replaceSubExpression(double replaceWith, String[] oldProgramTokens, int startReplaceIndex, int stopReplaceIndex) {
        String[] newProgramTokens = new String[oldProgramTokens.length - (stopReplaceIndex - startReplaceIndex)];

        for (int index = 0; index < startReplaceIndex; index++) {
            newProgramTokens[index] = oldProgramTokens[index];
        }

        newProgramTokens[startReplaceIndex] = String.valueOf(replaceWith);

        for (int index = 0; index < oldProgramTokens.length - stopReplaceIndex - 1; index++) {
            newProgramTokens[startReplaceIndex + index + 1] = oldProgramTokens[stopReplaceIndex + index + 1];
        }

        return newProgramTokens;
    }
}
