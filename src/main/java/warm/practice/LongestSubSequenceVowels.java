package warm.practice;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * https://www.geeksforgeeks.org/longest-ordered-subsequence-of-vowels/
 * 
 * @author dharamrajverma
 *
 */

public class LongestSubSequenceVowels {

    static Map<Character, Integer> map = new LinkedHashMap<>();

    public static void main(String[] args) {
        map.put('a', 0);
        map.put('e', 1);
        map.put('i', 2);
        map.put('o', 3);
        map.put('u', 4);
        // String s = "auaaioeoiaooaauoeuaueouuoeiiooiiaiiuioio"; // ans 14
        String s = "aeiaaioooaauuaeiou"; // ans 10
        System.out.println(longestSubSequence(s, "", 0));

    }

    static int longestSubSequence(String s, String subSeq, int i) {
        if (i == s.length()) {
            return isValid(subSeq) ? subSeq.length() : 0;
        }
        if (subSeq.length() == 0) { // start with a only
            if (s.charAt(i) == 'a') {
                return longestSubSequence(s, subSeq + s.charAt(i), i + 1);
            } else {
                return longestSubSequence(s, subSeq, i + 1);
            }
        }
        if (s.charAt(i) == subSeq.charAt(subSeq.length() - 1)) { // include if current vowel equal to last included
            return longestSubSequence(s, subSeq + s.charAt(i), i + 1);
        }
        if (map.get(s.charAt(i)) == (map.get(subSeq.charAt(subSeq.length() - 1)) + 1)) { // if current char is
                                                                                         // next vowel then
                                                                                         // include & not include
            System.out.println(s.charAt(i) + " " + subSeq.charAt(subSeq.length() - 1));
            return Math.max(longestSubSequence(s, subSeq, i + 1), longestSubSequence(s, subSeq + s.charAt(i), i + 1));
        } // otherwise keep moving
        return longestSubSequence(s, subSeq, i + 1);
    }

    static boolean isValid(String s) {
        System.out.println("sub: " + s);
        for (char c : map.keySet()) {
            if (!s.contains(c + ""))
                return false;
        }
        return true;
    }

}
