package com.antumbrastation.romanNumberalCalc;

public class CmdLine {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.exit(1);
        }

        String[] tokens = CalculatorGrammar.lexProgramIntoTokens(args[0]);
        tokens = CalculatorGrammar.replaceRomanTokensWithArabicTokens(tokens);

        System.out.println(CalculatorGrammar.evalCalculatorProgram(tokens));
    }
}
