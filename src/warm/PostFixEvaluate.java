package warm;

import java.util.Scanner;
import java.util.Stack;

public class PostFixEvaluate {

    public static void main(String srgs[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (--t >= 0) {
            String exp = sc.next();
            try {
                System.out.println((int) doPostFixEvalution(exp));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 
     * @param exp
     * @return
     * @throws Exception
     */
    private static double doPostFixEvalution(String exp) throws Exception {
        Stack<Double> s = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            if (isDigit(exp.charAt(i))) {
                s.push(Double.parseDouble(exp.charAt(i) + ""));
            } else {
                // pop two element -> evaluate -> push result
                double a = s.pop();
                double b = s.pop();
                double r = evaluate(a, b, exp.charAt(i));
                s.push(r);
            }
        }
        //System.out.println("Stack size: " + s.size());
        return s.pop();
    }

    private static boolean isDigit(char c) {
        return (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8'
                || c == '9') ? true : false;
    }

    private static double evaluate(double a, double b, char operator) throws Exception {
        switch (operator) {
        case '+':
            return b + a;
        case '-':
            return b - a;
        case '*':
            return b * a;
        case '/':
            return b / a;
        case '^':
            return Math.pow(b, a);
        default:
            throw new Exception("Invalid expression");
        }
    }

}
