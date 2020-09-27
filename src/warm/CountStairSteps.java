package warm;

import java.util.Scanner;

/**
 * https://www.geeksforgeeks.org/count-ways-reach-nth-stair-using-step-1-2-3/
 * 
 * Count ways to reach the nth stair using step 1, 2 or 3. A child is running up
 * a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a
 * time. Implement a method to count how many possible ways the child can run up
 * the stairs.
 * 
 * @author dharamrajverma
 *
 */
public class CountStairSteps {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println(findStep(sc.nextInt()));
    }

    // for steps 1,3,5
    static int findSteps(int n) {
        if (n < 0)
            return 0;
        if (n == 1 || n == 0)
            return 1;
        else
            return findSteps(n - 5) + findSteps(n - 1);
    }

    // Returns count of ways to reach
    // n-th stair using 1 or 2 or 3 steps.
    public static int findStep(int n) {
        if (n == 1 || n == 0)
            return 1;
        else if (n == 2)
            return 2;

        else
            return findStep(n - 3) + findStep(n - 2) + findStep(n - 1);
    }

}
