package warm.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequentKWords {

    public static void main(String[] args) {

        String comment = "paytm works on mutilple verticals. This help paytm to sustain. while flipcart not works in mutilple only e-com. flipcart should do in mutilple nmore";
        Map<String, Company> freqMap = new HashMap<>();
        String words[] = comment.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!freqMap.containsKey(word)) {
                freqMap.put(word, new Company(word, 0));
            }
            freqMap.get(word).frequency++;
        }
        List<Company> comList = new ArrayList<Company>(freqMap.values());
        Collections.sort(comList);
        for (Company c : comList) {
            System.out.println(c.name + " " + c.frequency);
        }
    }
    static class Company implements Comparable<Company> {
        String name;
        int frequency;

        Company(String name, int frequency) {
            this.name = name;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(Company o) {
            if (this.frequency != o.frequency)
                return this.frequency > o.frequency ? -1 : 1;
            return this.name.compareTo(o.name);
        }
    }
}
