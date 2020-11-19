package warm;

import java.util.Scanner;
import java.util.Stack;

public class InfixToPostFix {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        String exp = sc.next();
        System.out.println(covert(exp));
    }

    private static String covert(String exp) throws Exception {
        Stack<String> stack = new Stack<>();
        StringBuffer postFix = new StringBuffer();
        for (int i = 0; i < exp.length(); i++) {
            char input = exp.charAt(i);
            if (isDigit(exp.charAt(i))) {
                postFix.append(exp.charAt(i));
            } else {
                char top = 0;
                if (stack.size() > 0) {
                    top = stack.peek().toCharArray()[0];
                }
                System.out.println("top " + top + " input: " + input);
                if (input == ')') {
                    while (stack.size() > 0 && top != '(') {
                        char pop = stack.pop().toCharArray()[0];
                        System.out.println("apending " + pop);
                        postFix.append(pop);
                        if (stack.size() > 0) {
                            top = stack.peek().toCharArray()[0];
                        }
                    }
                    if (stack.size() > 0) {
                        stack.pop();
                    }
                } else {
                    while (needToPop(input, top) && stack.size() > 0) {
                        char pop = stack.pop().toCharArray()[0];
                        System.out.println("apendingg " + pop);
                        postFix.append(pop);
                        if (stack.size() > 0) {
                            top = stack.peek().toCharArray()[0];
                        }
                    }
                    System.out.println("pushing " + input);
                    stack.push(input + "");
                }

            }
        }
        while (stack.size() > 0) {
            postFix.append(stack.pop());
        }
        return new String(postFix);
    }

    private static boolean needToPop(char input, char top) throws Exception {
        switch (input) {
        case '+':
        case '-':
            if (top == '-' || top == '+' || top == '*' || top == '/' || top == '^') {
                return true;
            } else {
                return false;
            }
        case '*':
        case '/':
            if (top == '*' || top == '/' || top == '^') {
                return true;
            } else {
                return false;
            }
        case '^':
            return false;
        case '(':
            return false;
        default:
            throw new Exception("invalid Operand");
        }
    }

    private static boolean isDigit(char c) {
        return (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8'
                || c == '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') ? true : false;
    }

}
