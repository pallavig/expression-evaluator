package pallavig.evaluator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class EvaluatorTest {
    @Test
    public void testEvaluatingAnExpressionWithTwoOperandsAndAdditionOperator() throws Exception {
        String[] postfixArray = {"3", "4", "+"};
        List<String> postfix = Arrays.asList(postfixArray);
        EvaluatorLib evaluator = new EvaluatorLib(postfix);

        String result = evaluator.getResult();

        assertEquals(result, "7.0");
    }

    @Test
    public void testEvaluatingAnExpressionWithTwoOperandsAndMultiplicationOperator() throws Exception {
        String[] postfixArray = {"5", "10", "*"};
        List<String> postfix = Arrays.asList(postfixArray);
        EvaluatorLib evaluator = new EvaluatorLib(postfix);

        String result = evaluator.getResult();

        assertEquals(result, "50.0");
    }

    @Test
    public void testEvaluatingAnExpressionWithTwoOperandsAndSubstractionOperator() throws Exception {
        String[] postfixArray = {"1", "2", "-"};
        List<String> postfix = Arrays.asList(postfixArray);
        EvaluatorLib evaluator = new EvaluatorLib(postfix);

        String result = evaluator.getResult();

        assertEquals(result, "-1.0");
    }

    @Test
    public void testEvaluatingAnExpressionWithTwoOperandsAndDivisionOperator() throws Exception {
        String[] postfixArray = {"100", "2", "/"};
        List<String> postfix = Arrays.asList(postfixArray);
        EvaluatorLib evaluator = new EvaluatorLib(postfix);

        String result = evaluator.getResult();

        assertEquals(result, "50.0");
    }

    @Test
    public void testEvaluatingAnExpressionWithTwoOperandsAndPowerOfOperator() throws Exception {
        String[] postfixArray = {"5", "2", "^"};
        List<String> postfix = Arrays.asList(postfixArray);
        EvaluatorLib evaluator = new EvaluatorLib(postfix);

        String result = evaluator.getResult();

        assertEquals(result, "25.0");
    }

    @Test
    public void testEvaluatingExpressionWithTwoOperandsHavingFloatingPointNumber() throws Exception {
        String[] postfixArray = {"5.5", "2.5", "+"};
        List<String> postfix = Arrays.asList(postfixArray);
        EvaluatorLib evaluator = new EvaluatorLib(postfix);

        String result = evaluator.getResult();

        assertEquals(result, "8.0");
    }

    @Test
    public void testEvaluatingWithMultipleOperators() throws Exception {
        String[] postfixArray = {"2", "3", "+", "4", "*"};
        List<String> postfix = Arrays.asList(postfixArray);
        EvaluatorLib evaluator = new EvaluatorLib(postfix);

        String result = evaluator.getResult();

        assertEquals(result, "20.0");
    }

    @Test
    public void testEvaluatingWithFloatingPointNumbersAndMultipleOperators() throws Exception {
        String[] postfixArray = {"2", "3", "+", "4", "*", "5.5", "+", "2.5", "+"};
        List<String> postfix = Arrays.asList(postfixArray);
        EvaluatorLib evaluator = new EvaluatorLib(postfix);

        String result = evaluator.getResult();

        assertEquals(result, "28.0");
    }
}