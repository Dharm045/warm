package warm.practice;

import java.util.Arrays;

/**
 * Longest sub string with non repeating char
 * 
 * @author dharamrajverma
 *
 */
public class LongestNonRepeatingSubString {

    public static void main(String[] args) {
        String s = "ABDEFGABEF".toLowerCase();
        System.out.println(longestSubString(s));
    }

    static int longestSubString(String s) {
        if (s.length() == 0)
            return 0;
        int n = s.length();
        int visited[] = new int[26];
        Arrays.fill(visited, -1);

        int start = 0;
        int maxLength = 0, currentMax = 0;

        for (int i = 0; i < n; i++) {
            if (visited[s.charAt(i) - 97] != -1 && visited[s.charAt(i) - 97] >= start) {
                currentMax = i - visited[s.charAt(i) - 97];
                start = visited[s.charAt(i) - 97] + 1;
                System.out.println(s.charAt(i) + " " + i + " " + visited[s.charAt(i) - 97] + " " + currentMax+" "+start);
            } else {
                currentMax += 1;
                System.out.println("+1 " + s.charAt(i) + " " + visited[s.charAt(i) - 97] + " " + currentMax+" "+start + (visited[s.charAt(i) - 97] != 1 && visited[s.charAt(i) - 97] >= start));
            }
            visited[s.charAt(i) - 97] = i;
            maxLength = Math.max(maxLength, currentMax);
        }
        return maxLength;
    }

}
