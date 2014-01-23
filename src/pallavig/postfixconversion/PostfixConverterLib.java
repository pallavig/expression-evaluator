package pallavig.postfixconversion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostfixConverterLib {
    String expression;

    public PostfixConverterLib(String expression) {
        this.expression = expression;
    }

    private boolean isNumber(String arg) {
        try {
            Double.parseDouble(arg);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private String getExpressionWithSpacesBetweenOperatorAndOperand() {
        String expressionWithoutSpaces = expression.replaceAll("( )+", "")
                .replaceAll("\\+"," \\+ ").replaceAll("-"," - ").replaceAll("\\*"," \\* ")
                .replaceAll("/"," / ").replaceAll("\\(", " \\( ").replaceAll("\\)"," \\) ")
                .replaceAll("\\^"," \\^ ").replaceAll("  - "," -");
        String finalExpression = expressionWithoutSpaces.replaceAll("( )+", " ").trim();
        return finalExpression;
    }

    public List<String> givePostfix() {
        Stack<String> stack = new Stack<String>();
        expression = getExpressionWithSpacesBetweenOperatorAndOperand();
        String[] expressionParts = expression.split(" ");
        List<String> postfix = new ArrayList<String>();
        for (String expressionPart : expressionParts) {
            if (isNumber(expressionPart)) {
                postfix.add(expressionPart);
                if (stack.size() != 0 && !(stack.peek().equals("("))) {
                    postfix.add(stack.pop());
                }
                continue;
            }
            if (expressionPart.equals(")")) {
                stack.pop();
                if (stack.size() != 0 && !(stack.peek().equals("("))) {
                    postfix.add(stack.pop());
                }
                continue;
            }
            stack.push(expressionPart);
        }
        return postfix;
    }
}