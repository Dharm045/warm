package warm;

/**
 * Subset of a string ABC - "" A,B,C,AB,BC,AC,ABC
 * 
 * @author dharamrajverma
 *
 */

// TODO not working
public class SubSets {

    public static void main(String[] args) {
        SubSets subSets = new SubSets();
        String str = "ABC";
        int index = 0;
        subSets.subSets(str, new StringBuffer(" "), index);
    }

    private void subSets(String str, StringBuffer current, int index) {

        if (index == str.length()) {
            System.out.println(current);
            return;
        }
        subSets(str, current, index + 1);
        subSets(str, current.append(str.charAt(index)), index + 1);
    }

}
