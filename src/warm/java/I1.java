package warm.java;

@FunctionalInterface
public interface I1 {

    void method1();
    
    default void log(String str) {
        System.out.println(" I1 log " + str);
    }

    static void print(String str) {
        System.out.println("I1 print " + str);
    }

   
}
