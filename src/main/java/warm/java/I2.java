package warm.java;

public interface I2 {

    void method2();

    default void log(String str) {
        System.out.println(" I1 log " + str);
    }

}
