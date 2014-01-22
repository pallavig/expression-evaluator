package pallavig.postfixconversion;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class postfixConverterTest {

    public boolean areStringArrayEqual(String[] expected,String[] actual){
        if(expected.length != actual.length)
            return false;
        for (int i = 0; i < expected.length; i++) {
            if(!(expected[i].equals(actual[i]))) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testConvertExpressionHavingTwoOperandsAndAdditionOperatorToPostfix() throws Exception {
        String expression = "3 + 4";
        String[] expected = {"3","4","+"};
        PostfixConverterLib converter = new PostfixConverterLib(expression);

        String[] postfix = converter.givePostfix();

        assert(areStringArrayEqual(expected,postfix));
    }

    @Test
    public void testConvertExpressionHavingTwoOperandsAndMultiplicationOperatorToPostfix() throws Exception {
        String expression = "3 * 4";
        String[] expected = {"3","4","*"};

        PostfixConverterLib converter = new PostfixConverterLib(expression);
        String[] postfix = converter.givePostfix();

        assert(areStringArrayEqual(expected,postfix));
    }

    @Test
    public void testConversionWithFloatingPointNumbers() throws Exception {
        String expression = "3.3 / 4.4";
        String[] expected = {"3.3","4.4","/"};
        PostfixConverterLib converter = new PostfixConverterLib(expression);

        String[] postfix = converter.givePostfix();

        assert(areStringArrayEqual(expected,postfix));
    }

    @Test
    public void testConversionWithFloatingPointNumberAndPowerOperator() throws Exception {
        String expression = "1100.2 ^ 34.2";
        String[] expected = {"1100.2","34.2","^"};
        PostfixConverterLib converter = new PostfixConverterLib(expression);

        String[] postfix = converter.givePostfix();

        assert(areStringArrayEqual(expected,postfix));
    }


}
