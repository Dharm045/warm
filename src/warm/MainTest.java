package warm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainTest {

    public static void main(String[] args) {
     List<Integer> lst = new ArrayList<>();
     lst.add(4);
     lst.add(2);
     lst.add(10);
     lst.add(1);
     Collections.sort(lst);
     for(int i =0; i < lst.size(); i++) {
         System.out.println(lst.get(i)+" ");
     }
     
             
    }
    
  
}
