package com.antumbrastation.romanNumberalCalc;

import org.junit.Assert;
import org.junit.Test;

public class TestCalculatorGrammar {

    @Test
    public void testBasicLexing() {
        String[] tokens = CalculatorGrammar.lexProgramIntoTokens("( IV + II ) * VI / VIII");

        Assert.assertEquals(9, tokens.length);
        Assert.assertEquals("(", tokens[0]);
        Assert.assertEquals("IV", tokens[1]);
        Assert.assertEquals("+", tokens[2]);
        Assert.assertEquals("II", tokens[3]);
        Assert.assertEquals(")", tokens[4]);
        Assert.assertEquals("*", tokens[5]);
        Assert.assertEquals("VI", tokens[6]);
        Assert.assertEquals("/", tokens[7]);
        Assert.assertEquals("VIII", tokens[8]);
    }

    @Test
    public void testLexingWithManySpaces() {
     /*   String[] tokens = CalculatorGrammar.lexProgramIntoTokens("  (   IV  + II ) *    VI / VIII      ");

        Assert.assertEquals(9, tokens.length);
        Assert.assertEquals("(", tokens[0]);
        Assert.assertEquals("IV", tokens[1]);
        Assert.assertEquals("+", tokens[2]);
        Assert.assertEquals("II", tokens[3]);
        Assert.assertEquals(")", tokens[4]);
        Assert.assertEquals("*", tokens[5]);
        Assert.assertEquals("VI", tokens[6]);
        Assert.assertEquals("/", tokens[7]);
        Assert.assertEquals("VIII", tokens[8]);*/
    }

    @Test
    public void testNumeralSubstitution() {
        String[] tokens = {
                "(", "IV", "+", "II", ")", "*", "VI", "/", "VIII"
        };

        tokens = CalculatorGrammar.replaceRomanTokensWithArabicTokens(tokens);
        Assert.assertEquals(9, tokens.length);
        Assert.assertEquals("(", tokens[0]);
        Assert.assertEquals("4", tokens[1]);
        Assert.assertEquals("+", tokens[2]);
        Assert.assertEquals("2", tokens[3]);
        Assert.assertEquals(")", tokens[4]);
        Assert.assertEquals("*", tokens[5]);
        Assert.assertEquals("6", tokens[6]);
        Assert.assertEquals("/", tokens[7]);
        Assert.assertEquals("8", tokens[8]);
    }

    @Test
    public void testReplaceSubExpressionInMiddle() {
        String[] tokens = {
                "(", "IV", "+", "II", ")", "*", "VI", "/", "VIII"
        };
        tokens = CalculatorGrammar.replaceSubExpression(3.4, tokens, 1, 3);

        Assert.assertEquals(7, tokens.length);
        Assert.assertEquals("(", tokens[0]);
        Assert.assertEquals("3.4", tokens[1]);
        Assert.assertEquals(")", tokens[2]);
        Assert.assertEquals("*", tokens[3]);
        Assert.assertEquals("VI", tokens[4]);
        Assert.assertEquals("/", tokens[5]);
        Assert.assertEquals("VIII", tokens[6]);
    }

    @Test
    public void testReplaceSubExpressionWholeThing() {
        String[] tokens = {
                "(", "IV", "+", "II", ")", "*", "VI", "/", "VIII"
        };
        tokens = CalculatorGrammar.replaceSubExpression(3.4, tokens, 0, 8);

        Assert.assertEquals(1, tokens.length);
        Assert.assertEquals("3.4", tokens[0]);
    }

    @Test
    public void testReplaceSubExpressionAtEnd() {
        String[] tokens = {
                "(", "IV", "+", "II", ")", "*", "VI", "/", "VIII"
        };
        tokens = CalculatorGrammar.replaceSubExpression(3.4, tokens, 7, 8);

        Assert.assertEquals(8, tokens.length);
        Assert.assertEquals("(", tokens[0]);
        Assert.assertEquals("IV", tokens[1]);
        Assert.assertEquals("+", tokens[2]);
        Assert.assertEquals("II", tokens[3]);
        Assert.assertEquals(")", tokens[4]);
        Assert.assertEquals("*", tokens[5]);
        Assert.assertEquals("VI", tokens[6]);
        Assert.assertEquals("3.4", tokens[7]);
    }

    @Test
    public void probe() {
        String[] tokens = {
                "(", "(", "IV", "+", "II", ")", ")", "*", "(", "VI", "/", "VIII", ")"
        };
        tokens = CalculatorGrammar.replaceRomanTokensWithArabicTokens(tokens);

        CalculatorGrammar.evalCalculatorProgram(tokens);
    }
}
