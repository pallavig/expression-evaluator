package main;

import pallavig.evaluator.EvaluatorLib;
import pallavig.postfixconversion.PostfixConverter;

public class Evaluator {
    public static void main(String[] args) {
        PostfixConverter converter = new PostfixConverter(args[0]);
        String[] postfix = converter.givePostfix();
        EvaluatorLib evaluator = new EvaluatorLib(postfix);
        String result = evaluator.getResult();
        System.out.println(result);
    }
}