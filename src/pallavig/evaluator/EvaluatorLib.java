package pallavig.evaluator;

import java.util.Stack;

public class EvaluatorLib {
    String[] postfix;
    public EvaluatorLib(String[] postfix) {
        this.postfix = postfix;
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

    public String performSpecifiedOperation(int number1,int number2,String operator) {
        Integer result;
        if(operator.equals("+")){
            result = number1+ number2;
            return result.toString();
        }
        if(operator.equals("*")) {
            result = number1 * number2;
            return result.toString();
        }
        if(operator.equals("-")) {
            result = number1 - number2;
            return result.toString();
        }
        if(operator.equals("/")) {
            result = number1 / number2;
            return result.toString();
        }
        if(operator.equals("^")) {
            Double res  = Math.pow((double)number1,(double)number2);
            return res.toString();
        }
        return null;
    }

    public String getResult() {
        Stack<String> stack= new Stack<String>();
        for (String expressionPart : postfix) {
            if(isInteger(expressionPart)) {
                stack.push(expressionPart);
                continue;
            }
            int number2 = Integer.parseInt(stack.pop());
            int number1 = Integer.parseInt(stack.pop());
            stack.push(performSpecifiedOperation(number1,number2,expressionPart));
        }
        return stack.pop();
    }
}