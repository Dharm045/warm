package warm;

import java.util.Scanner;
import java.util.Stack;

public class PostFixToInfix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.next();
        System.out.println(covert(exp));
    }

    private static String covert(String exp) {
        Stack<String> s = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            if (isDigit(exp.charAt(i))) {
                s.push(exp.charAt(i) + "");
            } else {
                String a = s.pop();
                String b = s.pop();
                s.push("("+b + exp.charAt(i) + a+")");
            }
        }
        System.out.println("stack size " + s.size());
        return s.pop();
    }

    private static boolean isDigit(char c) {
        return (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8'
                || c == '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') ? true : false;
    }

}
