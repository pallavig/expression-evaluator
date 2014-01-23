package main;

import pallavig.evaluator.EvaluatorLib;
import pallavig.postfixconversion.PostfixConverterLib;

import java.util.List;

public class Evaluator {
    public static void main(String[] args) {
        PostfixConverterLib converter = new PostfixConverterLib(args[0]);
        List<String> postfix = converter.givePostfix();
        EvaluatorLib evaluator = new EvaluatorLib(postfix);
        String result = evaluator.getResult();
        System.out.println(result);
    }
}