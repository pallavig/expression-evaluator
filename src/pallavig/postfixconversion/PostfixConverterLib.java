package pallavig.postfixconversion;

import java.util.Stack;

public class PostfixConverterLib {
    String expression;
    public PostfixConverterLib(String expression) {
        this.expression = expression;
    }
    private boolean isInteger(String arg) {
        try{
            Integer.parseInt(arg);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    public String[] givePostfix() {
        Stack<String> stack = new Stack<String>();
        String[] expressionParts = expression.split(" ");
        String[] postfix = new String[expressionParts.length];
        int i = 0;
        for (String expressionPart : expressionParts) {
            if(isInteger(expressionPart)) {
                postfix[i] = expressionPart;
                i++;
                if(stack.size() != 0) {
                    postfix[i] = stack.pop();
                    i++;
                }
                continue;
            }
            stack.push(expressionPart);
        }
        while(stack.size() != 0) {
            postfix[i] = stack.pop();
            i++;
        }
        return postfix;
    }
}