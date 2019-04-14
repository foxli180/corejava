package ch06.lambda;

import org.testng.annotations.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.function.IntConsumer;

public class LambdaTest {


    @Test
    public void test1() {
        String[] planets = new String[] {"Mercury", "Venus", "Earth", "Mars", "Jupiter"};
        System.out.println(Arrays.toString(planets));

        System.out.println("Sorted in dictionary order:");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));

        System.out.println("Sorted by length: ");
        Arrays.sort(planets, Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(planets));

        Timer t = new Timer(1000, event -> System.out.println("The time is: " + new Date()));
        t.start();

        JOptionPane.showMessageDialog(null, "Quit?");
        System.exit(0);

    }


    @Test
    public void test2() {
        ArrayList<String> lists = new ArrayList<>();
        lists.add("a");
        lists.add(null);
        lists.add("b");
        lists.add(null);
        System.out.println(lists);
        lists.removeIf(e -> e == null);
        System.out.println(lists);

    }

    @Test
    public void test_function_handle_lambda(){
        repeat(10, ()->System.out.println("Hello"));
    }

    @Test
    public void test_function_handle_lambda2() {
        repeatV2(10, i-> System.out.println("CountDown: " + (9 -i)), i->System.out.println("After: " + i));
    }

    public static void repeat(int n, Runnable runnable) {
        for(int i = 0; i < n; i ++) {
            runnable.run();
        }
    }

    public static void repeatV2(int n, IntConsumer action, IntConsumer after) {
        for(int i = 0; i < n; i++) {
            action.andThen(after).accept(i);
        }
    }


}
