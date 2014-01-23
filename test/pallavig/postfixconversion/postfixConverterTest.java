package pallavig.postfixconversion;

import org.junit.Test;

public class postfixConverterTest {

    public boolean areStringArrayEqual(String[] expected, String[] actual) {
        if (expected.length != actual.length)
            return false;
        for (int i = 0; i < expected.length; i++) {
            if (!(expected[i].equals(actual[i]))) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testConvertExpressionHavingTwoOperandsAndAdditionOperatorToPostfix() throws Exception {
        String expression = "3 + 4";
        String[] expected = {"3", "4", "+"};
        PostfixConverterLib converter = new PostfixConverterLib(expression);

        String[] postfix = converter.givePostfix();

        assert (areStringArrayEqual(expected, postfix));
    }

    @Test
    public void testConvertExpressionHavingTwoOperandsAndMultiplicationOperatorToPostfix() throws Exception {
        String expression = "3 * 4";
        String[] expected = {"3", "4", "*"};

        PostfixConverterLib converter = new PostfixConverterLib(expression);
        String[] postfix = converter.givePostfix();

        assert (areStringArrayEqual(expected, postfix));
    }

    @Test
    public void testConversionWithFloatingPointNumbers() throws Exception {
        String expression = "3.3 / 4.4";
        String[] expected = {"3.3", "4.4", "/"};
        PostfixConverterLib converter = new PostfixConverterLib(expression);

        String[] postfix = converter.givePostfix();

        assert (areStringArrayEqual(expected, postfix));
    }

    @Test
    public void testConversionWithFloatingPointNumberAndPowerOperator() throws Exception {
        String expression = "1100.2 ^ 34.2";
        String[] expected = {"1100.2", "34.2", "^"};
        PostfixConverterLib converter = new PostfixConverterLib(expression);

        String[] postfix = converter.givePostfix();

        assert (areStringArrayEqual(expected, postfix));
    }

    @Test
    public void testConversionWithMultipleOperators() throws Exception {
        String expression = "2 + 3 * 4";
        String[] expected = {"2", "3", "+", "4", "*"};
        PostfixConverterLib converter = new PostfixConverterLib(expression);

        String[] postfix = converter.givePostfix();

        assert (areStringArrayEqual(expected, postfix));
    }

    @Test
    public void testConversionWithFloatingPointNumbersAndMultipleOperators() throws Exception {
        String expression = "2 + 3 * 4 + 5.5 + 2.5";
        String[] expected = {"2", "3", "+", "4", "*", "5.5", "+", "2.5", "+"};
        PostfixConverterLib converter = new PostfixConverterLib(expression);

        String[] postfix = converter.givePostfix();

        assert (areStringArrayEqual(expected, postfix));
    }

    @Test
    public void testConversionOfExpressionWithOnlyOnePairOfBraces() throws Exception {
        String expression = "2 + ( 3 * 4 )";
        String[] expected = {"2", "3", "4", "*", "+"};
        PostfixConverterLib converter = new PostfixConverterLib(expression);

        String[] postfix = converter.givePostfix();

        assert (areStringArrayEqual(expected, postfix));
    }

    @Test
    public void testConversionOfExpressionWithOnlyMultiplePairOfBraces() throws Exception {
        String expression = "2 + ( 3 * 4 ) + ( 4 + 5 ) * 6";
        String[] expected = {"2", "3", "4", "*", "+", "4", "5", "+", "+", "6", "*"};
        PostfixConverterLib converter = new PostfixConverterLib(expression);

        String[] postfix = converter.givePostfix();

        assert (areStringArrayEqual(expected, postfix));
    }

    @Test
    public void testConversionOfExpressionWithOnlyMultiplePairOfBracesWithFloats() throws Exception {
        String expression = "2.0 + ( 3 * 4 ) + ( 4 + 5.5 ) * 6.2";
        String[] expected = {"2.0", "3", "4", "*", "+", "4", "5.5", "+", "+", "6.2", "*"};
        PostfixConverterLib converter = new PostfixConverterLib(expression);

        String[] postfix = converter.givePostfix();

        assert (areStringArrayEqual(expected, postfix));
    }

    @Test
    public void testConversionWhenFirstCharacterIsOpeningBrace() throws Exception {
        String expression = "( 3 + 4 )";
        String[] expected = {"3", "4", "+"};
        PostfixConverterLib converter = new PostfixConverterLib(expression);

        String[] postfix = converter.givePostfix();

        assert (areStringArrayEqual(expected, postfix));
    }
}