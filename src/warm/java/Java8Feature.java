package warm.java;

import java.util.Optional;

public class Java8Feature {

    public static void main(String args[]) {
        
        String a = null;
        Optional<String> optional = Optional.of(a);
        if(optional.equals("test")) {
            System.out.println("equal == ");
        } else {
            System.out.println("not equal");
        }
        
    }
    
}
