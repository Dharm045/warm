package warm.java;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class TestC implements I1, I2 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer i) {
                System.out.println("item " + i);
            }
        });

        list.forEach(item -> System.out.println(item));

        TestC testC = new TestC();
        testC.log("123456");
        testC.print("123");

    }

    @Override
    public void method2() {
        // TODO Auto-generated method stub

    }

    @Override
    public void method1() {
        // TODO Auto-generated method stub

    }

    @Override
    public void log(String str) {

        System.out.println("TestC " + str);
        I1.print("abc");
    }

   
    public void print(String str) {
        System.out.println("class print "+str);
        I1.print("12");
    }
    
    @Override
    public String toString() {
        return "class tostring ";
    }
    
}
