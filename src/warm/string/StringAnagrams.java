package warm.string;

import java.util.Scanner;

/**
 * Given a string S. The task is to print all permutations of a given string.
 * 
 * @author dharamrajverma
 *
 */
public class StringAnagrams {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (--t >= 0) {
            String input = sc.next();
            anagrams(input);
        }

    }

    private static void anagrams(String input) {

        if (input == null || input.isEmpty()) {
            return;
        }

        int len = input.length();
        int totalAnagrams = 1;
        for (int i = len; i > 0; i--) {
            totalAnagrams = totalAnagrams * i;
        }
        // System.out.println("totalAnagrams " + totalAnagrams);

        int rows = len;
        int cols = totalAnagrams / len;

        StringBuffer anagram[][] = new StringBuffer[rows][cols];

        // input = ABC
        for (int index = 0; index < rows; index++) {

            // fill startChar on each col in respective row i.e A
            for (int col = 0; col < cols; col++) {
                anagram[index][col] = new StringBuffer(input.charAt(index) + "");
            }

            // get chars other than start char ie BC
            StringBuffer permStr = new StringBuffer();
            for (int i = 0; i < len; i++) {
                if (i != index) {
                    permStr.append(input.charAt(i));
                }
            }

            System.out.println("permStr " + permStr);

            // append permutation in each col 1 by 1 and reverse too. BC,CB
            for (int p = 0; p < permStr.length(); p++) {

                String appendStr = getPermutationsChars(new String(permStr), p);
                String fwdRevcahrs = getFwdRevString(appendStr);
                System.out.println("appendStr " + appendStr + " cols " + cols + " fwdRevcahrs " + fwdRevcahrs);

                for (int col = 0; col < cols; col++) {
                    anagram[index][col].append(fwdRevcahrs.charAt(col));
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(anagram[row][col] + " ");
            }
            // System.out.println();
        }
        System.out.println();
    }

    /**
     * Arrange chars in order
     * 
     * for str = BCD & index = 1 ==> CDB
     * 
     * @param permutationChars
     * @param index
     * @return
     */
    private static String getPermutationsChars(String permutationChars, int index) {
        int len = permutationChars.length();
        int start = index + 1;
        StringBuffer permStr = new StringBuffer(permutationChars.charAt(index) + "");
        while (start < len) {
            permStr.append(permutationChars.charAt(start));
            start++;
        }
        start = 0;
        while (start < index) {
            permStr.append(permutationChars.charAt(start));
            start++;
        }
        return new String(permStr);
    }

    /**
     * mirror the string to make forward & reverse of it. BCD ==> BCDDCB
     * 
     * @param value
     * @return
     */
    private static String getFwdRevString(String value) {
        String fwdRevcahrs = new String(value);
        fwdRevcahrs = fwdRevcahrs + new StringBuffer(value).reverse();
        return fwdRevcahrs;
    }

}
