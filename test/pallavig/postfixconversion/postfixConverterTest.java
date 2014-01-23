package pallavig.postfixconversion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class postfixConverterTest {

    public boolean areListsEqual(List<String> expected,List<String> actual) {
        if (expected.size() != actual.size())
            return false;
        for (int i = 0; i < expected.size(); i++) {
            if (!(expected.get(i).equals(actual.get(i)))) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testConvertExpressionHavingTwoOperandsAndAdditionOperatorToPostfix() throws Exception {
        String expression = "3 + 4";
        String[] expectedArray = {"3", "4", "+"};
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

        assertEquals (expected, postfix);
    }

    @Test
    public void testConversionWithFloatingPointNumbersAndMultipleOperators() throws Exception {
        String expression = "2 + 3 * 4 + 5.5 + 2.5";
        String[] expectedArray = {"2", "3", "+", "4", "*", "5.5", "+", "2.5", "+"};
        List<String> expected = Arrays.asList(expectedArray);
        PostfixConverterLib converter = new PostfixConverterLib(expression);

        List<String> postfix = converter.givePostfix();

        assertEquals (expected, postfix);
    }

    @Test
    public void testConversionOfExpressionWithOnlyOnePairOfBraces() throws Exception {
        String expression = "2 + ( 3 * 4 )";
        String[] expectedArray = {"2", "3", "4", "*", "+"};
        List<String> expected = Arrays.asList(expectedArray);
        PostfixConverterLib converter = new PostfixConverterLib(expression);

        List<String> postfix = converter.givePostfix();

        assertEquals (expected, postfix);
    }

    @Test
    public void testConversionOfExpressionWithOnlyMultiplePairOfBraces() throws Exception {
        String expression = "2 + ( 3 * 4 ) + ( 4 + 5 ) * 6";
        String[] expectedArray = {"2", "3", "4", "*", "+", "4", "5", "+", "+", "6", "*"};
        List<String> expected = Arrays.asList(expectedArray);
        PostfixConverterLib converter = new PostfixConverterLib(expression);

        List<String> postfix = converter.givePostfix();

        assertEquals (expected, postfix);
    }

    @Test
    public void testConversionOfExpressionWithOnlyMultiplePairOfBracesWithFloats() throws Exception {
        String expression = "2.0 + ( 3 * 4 ) + ( 4 + 5.5 ) * 6.2";
        String[] expectedArray = {"2.0", "3", "4", "*", "+", "4", "5.5", "+", "+", "6.2", "*"};
        List<String> expected = Arrays.asList(expectedArray);
        PostfixConverterLib converter = new PostfixConverterLib(expression);

        List<String> postfix = converter.givePostfix();

        assertEquals (expected, postfix);
    }

    @Test
    public void testConversionWhenFirstCharacterIsOpeningBrace() throws Exception {
        String expression = "( 3 + 4 )";
        String[] expectedArray = {"3", "4", "+"};
        List<String> expected = Arrays.asList(expectedArray);
        PostfixConverterLib converter = new PostfixConverterLib(expression);

        List<String> postfix = converter.givePostfix();

        assertEquals (expected, postfix);
    }
}