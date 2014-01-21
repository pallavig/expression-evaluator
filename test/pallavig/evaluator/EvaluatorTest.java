package pallavig.evaluator;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class EvaluatorTest {
    @Test
    public void testEvaluatingAnExpressionWithTwoOperandsAndAdditionOperator() throws Exception {
        String[] postfix = {"3","4","+"};
        EvaluatorLib evaluator = new EvaluatorLib(postfix);
        String result = evaluator.getResult();
        assertEquals(result,"7");
    }

    @Test
    public void testEvaluatingAnExpressionWithTwoOperandsAndMultiplicationOperator() throws Exception {
        String[] postfix = {"5","10","*"};
        EvaluatorLib evaluator = new EvaluatorLib(postfix);
        String result = evaluator.getResult();
        assertEquals(result,"50");
    }

    @Test
    public void testEvaluatingAnExpressionWithTwoOperandsAndSubstractionOperator() throws Exception {
        String[] postfix = {"1","2","-"};
        EvaluatorLib evaluator = new EvaluatorLib(postfix);
        String result = evaluator.getResult();
        assertEquals(result,"-1");
    }

    @Test
    public void testEvaluatingAnExpressionWithTwoOperandsAndDivisionOperator() throws Exception {
        String[] postfix = {"100","2","/"};
        EvaluatorLib evaluator = new EvaluatorLib(postfix);
        String result = evaluator.getResult();
        assertEquals(result,"50");
    }

    @Test
    public void testEvaluatingAnExpressionWithTwoOperandsAndPowerOfOperator() throws Exception {
        String[] postfix = {"5","2","^"};
        EvaluatorLib evaluator = new EvaluatorLib(postfix);
        String result = evaluator.getResult();
        assertEquals(result,"25.0");
    }
}