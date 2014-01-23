package pallavig.postfixconversion;

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

    private int getLength() {
        String[] expressionParts = expression.split(" ");
        int length = 0;
        for (String expressionPart : expressionParts) {
            if (expressionPart.equals(")") || expressionPart.equals("("))
                length--;
            length++;
        }
        return length;
    }

    public String[] givePostfix() {
        Stack<String> stack = new Stack<String>();
        String[] expressionParts = expression.split(" ");
        String[] postfix = new String[getLength()];
        int i = 0;
        for (String expressionPart : expressionParts) {
            if (isNumber(expressionPart)) {
                postfix[i] = expressionPart;
                i++;
                if (stack.size() != 0) {
                    if (!(stack.peek().equals("("))) {
                        postfix[i] = stack.pop();
                        i++;
                    }
                }
                continue;
            }
            if (expressionPart.equals(")")) {
                stack.pop();
                if (stack.size() != 0) {
                    postfix[i] = stack.pop();
                    i++;
                }
                continue;
            }
            stack.push(expressionPart);
        }
        while (stack.size() != 0) {
            postfix[i] = stack.pop();
            i++;
        }
        return postfix;
    }
}