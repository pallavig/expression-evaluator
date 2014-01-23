package pallavig.evaluator;

import java.util.Stack;

public class EvaluatorLib {
    String[] postfix;

    public EvaluatorLib(String[] postfix) {
        this.postfix = postfix;
    }

    private boolean isNumber(String arg) {
        try {
            Double.parseDouble(arg);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String performSpecifiedOperation(double number1, double number2, String operator) {
        Double result;
        if (operator.equals("+")) {
            result = number1 + number2;
            return result.toString();
        }
        if (operator.equals("*")) {
            result = number1 * number2;
            return result.toString();
        }
        if (operator.equals("-")) {
            result = number1 - number2;
            return result.toString();
        }
        if (operator.equals("/")) {
            result = number1 / number2;
            return result.toString();
        }
        if (operator.equals("^")) {
            result = Math.pow(number1, number2);
            return result.toString();
        }
        return null;
    }

    public String getResult() {
        Stack<String> stack = new Stack<String>();
        for (String expressionPart : postfix) {
            if (isNumber(expressionPart)) {
                stack.push(expressionPart);
                continue;
            }
            double number2 = Double.parseDouble(stack.pop());
            double number1 = Double.parseDouble(stack.pop());
            stack.push(performSpecifiedOperation(number1, number2, expressionPart));
        }
        return stack.pop();
    }
}