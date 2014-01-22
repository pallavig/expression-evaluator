package pallavig.evaluator;
import main.Evaluator;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class EvaluatorTest {
    @Test
    public void testEvaluatingAnExpressionWithTwoOperandsAndAdditionOperator() throws Exception {
        String[] postfix = {"3","4","+"};
        EvaluatorLib evaluator = new EvaluatorLib(postfix);

        String result = evaluator.getResult();

        assertEquals(result,"7.0");
    }

    @Test
    public void testEvaluatingAnExpressionWithTwoOperandsAndMultiplicationOperator() throws Exception {
        String[] postfix = {"5","10","*"};
        EvaluatorLib evaluator = new EvaluatorLib(postfix);

        String result = evaluator.getResult();

        assertEquals(result,"50.0");
    }

    @Test
    public void testEvaluatingAnExpressionWithTwoOperandsAndSubstractionOperator() throws Exception {
        String[] postfix = {"1","2","-"};
        EvaluatorLib evaluator = new EvaluatorLib(postfix);

        String result = evaluator.getResult();

        assertEquals(result,"-1.0");
    }

    @Test
    public void testEvaluatingAnExpressionWithTwoOperandsAndDivisionOperator() throws Exception {
        String[] postfix = {"100","2","/"};
        EvaluatorLib evaluator = new EvaluatorLib(postfix);

        String result = evaluator.getResult();

        assertEquals(result,"50.0");
    }

    @Test
    public void testEvaluatingAnExpressionWithTwoOperandsAndPowerOfOperator() throws Exception {
        String[] postfix = {"5","2","^"};
        EvaluatorLib evaluator = new EvaluatorLib(postfix);

        String result = evaluator.getResult();

        assertEquals(result,"25.0");
    }

    @Test
    public void testEvaluatingExpressionWithTwoOperandsHavingFloatingPointNumber() throws Exception {
        String[] postfix = {"5.5","2.5","+"};
        EvaluatorLib evaluator = new EvaluatorLib(postfix);

        String result = evaluator.getResult();

        assertEquals(result,"8.0");
    }
}