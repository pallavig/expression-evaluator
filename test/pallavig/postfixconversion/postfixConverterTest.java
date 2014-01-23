package pallavig.postfixconversion;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class postfixConverterTest {

    @Test
    public void testConvertExpressionHavingTwoOperandsAndAdditionOperatorToPostfix() throws Exception {
        String expression = "33 + 45";
        String[] expectedArray = {"33", "45", "+"};
        List<String> expected = Arrays.asList(expectedArray);
        PostfixConverterLib converter = new PostfixConverterLib(expression);

        List<String> postfix = converter.givePostfix();

        assertEquals(expected, postfix);
    }

    @Test
    public void testConversionWithOnlyOneNumber() throws Exception {
        String expression = "3";
        String[] expectedArray = {"3"};
        List<String> expected = Arrays.asList(expectedArray);
        PostfixConverterLib converter = new PostfixConverterLib(expression);

        List<String> postfix = converter.givePostfix();

        assertEquals(expected, postfix);
    }

    @Test
    public void testConvertExpressionHavingTwoOperandsAndMultiplicationOperatorToPostfix() throws Exception {
        String expression = "3 * 4";
        String[] expectedArray = {"3", "4", "*"};
        List<String> expected = Arrays.asList(expectedArray);
        PostfixConverterLib converter = new PostfixConverterLib(expression);

        List<String> postfix = converter.givePostfix();

        assertEquals(expected, postfix);
    }

    @Test
    public void testConversionWithFloatingPointNumbers() throws Exception {
        String expression = "3.3 / 4.4";
        String[] expectedArray = {"3.3", "4.4", "/"};
        List<String> expected = Arrays.asList(expectedArray);
        PostfixConverterLib converter = new PostfixConverterLib(expression);

        List<String> postfix = converter.givePostfix();

        assertEquals(expected, postfix);
    }

    @Test
    public void testConversionWithFloatingPointNumberAndPowerOperator() throws Exception {
        String expression = "1100.2 ^ 34.2";
        String[] expectedArray = {"1100.2", "34.2", "^"};
        List<String> expected = Arrays.asList(expectedArray);
        PostfixConverterLib converter = new PostfixConverterLib(expression);

        List<String> postfix = converter.givePostfix();

        assertEquals(expected, postfix);
    }

    @Test
    public void testConversionWithMultipleOperators() throws Exception {
        String expression = "2 + 3 * 4";
        String[] expectedArray = {"2", "3", "+", "4", "*"};
        List<String> expected = Arrays.asList(expectedArray);
        PostfixConverterLib converter = new PostfixConverterLib(expression);

        List<String> postfix = converter.givePostfix();

        assertEquals(expected, postfix);
    }

    @Test
    public void testConversionWithFloatingPointNumbersAndMultipleOperators() throws Exception {
        String expression = "2 + 3 * 4 + 5.5 + 2.5";
        String[] expectedArray = {"2", "3", "+", "4", "*", "5.5", "+", "2.5", "+"};
        List<String> expected = Arrays.asList(expectedArray);
        PostfixConverterLib converter = new PostfixConverterLib(expression);

        List<String> postfix = converter.givePostfix();

        assertEquals(expected, postfix);
    }

    @Test
    public void testConversionOfExpressionWithOnlyOnePairOfBraces() throws Exception {
        String expression = "2 + ( 3 * 4 )";
        String[] expectedArray = {"2", "3", "4", "*", "+"};
        List<String> expected = Arrays.asList(expectedArray);
        PostfixConverterLib converter = new PostfixConverterLib(expression);

        List<String> postfix = converter.givePostfix();

        assertEquals(expected, postfix);
    }

    @Test
    public void testConversionOfExpressionWithOnlyMultiplePairOfBraces() throws Exception {
        String expression = "2 + ( 3 * 4 ) + ( 4 + 5 ) * 6";
        String[] expectedArray = {"2", "3", "4", "*", "+", "4", "5", "+", "+", "6", "*"};
        List<String> expected = Arrays.asList(expectedArray);
        PostfixConverterLib converter = new PostfixConverterLib(expression);

        List<String> postfix = converter.givePostfix();

        assertEquals(expected, postfix);
    }

    @Test
    public void testConversionOfExpressionWithOnlyMultiplePairOfBracesWithFloats() throws Exception {
        String expression = "2.0 + ( 3 * 4 ) + ( 4 + 5.5 ) * 6.2";
        String[] expectedArray = {"2.0", "3", "4", "*", "+", "4", "5.5", "+", "+", "6.2", "*"};
        List<String> expected = Arrays.asList(expectedArray);
        PostfixConverterLib converter = new PostfixConverterLib(expression);

        List<String> postfix = converter.givePostfix();

        assertEquals(expected, postfix);
    }

    @Test
    public void testConversionWhenFirstCharacterIsOpeningBrace() throws Exception {
        String expression = "( 3 + 4 )";
        String[] expectedArray = {"3", "4", "+"};
        List<String> expected = Arrays.asList(expectedArray);
        PostfixConverterLib converter = new PostfixConverterLib(expression);

        List<String> postfix = converter.givePostfix();

        assertEquals(expected, postfix);
    }

    @Test
    public void testConversionWithMultipleOperatorsInBraces() throws Exception {
        String expression = "2 + ( 3 * 4 ^ 2 / 5 )";
        String[] expectedArray = {"2", "3", "4", "*", "2", "^", "5", "/", "+"};
        List<String> expected = Arrays.asList(expectedArray);
        PostfixConverterLib converter = new PostfixConverterLib(expression);

        List<String> postfix = converter.givePostfix();

        assertEquals(expected, postfix);
    }

    @Test
    public void testConversionWithOnlyOneOperandInsideBrace() throws Exception {
        String expression = "2 * ( 4 ) / 8";
        String[] expectedArray = {"2", "4", "*", "8", "/"};
        List<String> expected = Arrays.asList(expectedArray);
        PostfixConverterLib converter = new PostfixConverterLib(expression);

        List<String> postfix = converter.givePostfix();

        assertEquals(expected, postfix);
    }

    @Test
    public void testConversionWithNestedBraces() throws Exception {
        String expression = "( ( 3 + 4 ) )";
        String[] expectedArray = {"3", "4", "+"};
        List<String> expected = Arrays.asList(expectedArray);
        PostfixConverterLib converter = new PostfixConverterLib(expression);

        List<String> postfix = converter.givePostfix();

        assertEquals(expected, postfix);
    }

    @Test
    public void testConversionWithNestedBracesWithMultipleOperator() throws Exception {
        String expression = "2 * ( 8 * ( 2 + 3 ) + 1 ) / 100";
        String[] expectedArray = {"2", "8", "2", "3", "+", "*", "1", "+", "*", "100", "/"};
        List<String> expected = Arrays.asList(expectedArray);
        PostfixConverterLib converter = new PostfixConverterLib(expression);

        List<String> postfix = converter.givePostfix();

        assertEquals(expected, postfix);
    }

    @Test
    public void testConversionWhenBiggerExpressionIsPresentInBraces() throws Exception {
        String expression = "2 + ( 3 * 4 / 2 + ( 23 - 5 / 6 ) * 2 )";
        String[] expectedArray = {"2", "3", "4", "*", "2", "/", "23", "5", "-", "6", "/", "+", "2", "*", "+"};
        List<String> expected = Arrays.asList(expectedArray);
        PostfixConverterLib converter = new PostfixConverterLib(expression);

        List<String> postfix = converter.givePostfix();

        assertEquals(expected, postfix);
    }

    @Test
    public void testConversionWithOneOperandInsideTwoPairBraces() throws Exception {
        String expression = "( ( 2 ) )";
        String[] expectedArray = {"2"};
        List<String> expected = Arrays.asList(expectedArray);
        PostfixConverterLib converter = new PostfixConverterLib(expression);

        List<String> postfix = converter.givePostfix();

        assertEquals(expected, postfix);
    }

    @Test
    public void testConversionNegativeNumber() throws Exception {
        String expression = "2 - -3";
        String[] expectedArray = {"2","-3","-"};
        List<String> expected = Arrays.asList(expectedArray);
        PostfixConverterLib converter = new PostfixConverterLib(expression);

        List<String> postfix = converter.givePostfix();

        assertEquals(expected, postfix);
    }

    @Test
    public void testConversionOfExpressionWithOneOperatorWithoutSpaces() throws Exception {
        String expression = "33+45";
        String[] expectedArray = {"33", "45", "+"};
        List<String> expected = Arrays.asList(expectedArray);
        PostfixConverterLib converter = new PostfixConverterLib(expression);

        List<String> postfix = converter.givePostfix();

        assertEquals(expected, postfix);
    }


    @Test
    public void testConversionWithOnlyTwoOperands() throws Exception {
        String expression = "3--6";
        String[] expectedArray = {"3","-6","-"};
        List<String> expected = Arrays.asList(expectedArray);
        PostfixConverterLib converter = new PostfixConverterLib(expression);

        List<String> postfix = converter.givePostfix();

        assertEquals(expected, postfix);
    }

    @Test
    public void testConversionWithBraces() throws Exception {
        String expression = "(3--6)+4-50";
        String[] expectedArray = {"3","-6","-","4","+","50","-"};
        List<String> expected = Arrays.asList(expectedArray);
        PostfixConverterLib converter = new PostfixConverterLib(expression);

        List<String> postfix = converter.givePostfix();

        assertEquals(expected, postfix);
    }
}