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
        for (String token: programTokens) {
            System.out.println(token);
        }
        System.out.println("=======");

        if (programTokens.length == 0) {
            return 0;
        }

        // Handling sub expressions first
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
            String[] subExpression = new String[closingParenIndex - openingParenIndex - 1];
            System.arraycopy(programTokens, openingParenIndex + 1, subExpression, 0, subExpression.length);
            double evaluateSubExpression = evalCalculatorProgram(subExpression);
            return evalCalculatorProgram(replaceSubExpression(evaluateSubExpression, programTokens, openingParenIndex, closingParenIndex));
        }

        // If no sub expressions, next comes multiplication and division


        // Finally try addition/subtraction


        // By this point we're down to number literals

        return 0;
    }

    public static String[] replaceSubExpression(double replaceWith, String[] oldProgramTokens, int startReplaceIndex, int stopReplaceIndex) {
        String[] newProgramTokens = new String[oldProgramTokens.length - (stopReplaceIndex - startReplaceIndex)];

        System.arraycopy(oldProgramTokens, 0, newProgramTokens, 0, startReplaceIndex);
        newProgramTokens[startReplaceIndex] = String.valueOf(replaceWith);

        for (int index = 0; index < oldProgramTokens.length - stopReplaceIndex - 1; index++) {
            newProgramTokens[startReplaceIndex + index + 1] = oldProgramTokens[stopReplaceIndex + index + 1];
        }

        return newProgramTokens;
    }
}
