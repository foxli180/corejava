package test.ch08.generic;

import main.ch08.generic.Pair;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static org.testng.Assert.*;

public class PairTest {

    @Test
    public void test_Pair_With_String() {
        String[] words = {"Mary", "had", "a", "little", "lamb"};
        Pair<String> mm = minmax(words);
        assertEquals(mm.getFirst(), "Mary");
        assertEquals(mm.getSecond(), "little");

    }

    @Test
    public void test_Pair_With_Integer(){
        Integer[] numbers = {15, 2, 3, 4};
        Pair<Integer> mm = minmax(numbers);
        assertEquals(mm.getFirst(), Integer.valueOf(2));
        assertEquals(mm.getSecond(), Integer.valueOf(15));

    }

    @Test
    public void test_Pair_With_LocalDate() {
        LocalDate[] birthdays = {
             LocalDate.of(1906, 12, 9),
             LocalDate.of(1815, 12 ,10),
             LocalDate.of(1903, 12, 3),
             LocalDate.of(1910, 6, 22),
        };
        Pair<LocalDate> mm = minmax(birthdays);
        System.out.println(mm.getClass());
        System.out.println(mm instanceof Pair);
        assertEquals(mm.getFirst(), LocalDate.of(1815, 12, 10));
        assertEquals(mm.getSecond(), LocalDate.of(1910, 6, 22));
    }

    @Test
    public void test_1() {
        Pair p = Pair.makePair(String.class);
        System.out.println(p);
    }

//    private Pair<Integer> minmax(Integer[] numbers) {
//        if (numbers == null || numbers.length ==0) {
//            return null;
//        }
//        int min = numbers[0];
//        int max = numbers[0];
//        for(int i = 0; i < numbers.length; i++) {
//            if(min > numbers[i]) min = numbers[i];
//            if(max < numbers[i]) max = numbers[i];
//        }
//        return new Pair<>(min, max);
//    }
//
//    private Pair<String> minmax(String[] a) {
//        if (a == null || a.length == 0) return null;
//        String min = a[0];
//        String max = a[0];
//        for(int i = 1; i < a.length; i++) {
//            if(min.compareTo(a[i]) > 0) min = a[i];
//            if(max.compareTo(a[i]) < 0) max = a[i];
//        }
//        return new Pair<>(min, max);
//    }

    private <T extends Comparable> Pair<T> minmax(T[] a) {
        if (a == null || a.length == 0) return null;
        T min = a[0];
        T max = a[0];
        for(int i = 1; i < a.length; i++) {
            if(min.compareTo(a[i]) > 0) min = a[i];
            if(max.compareTo(a[i]) < 0) max = a[i];
        }
        return new Pair<>(min, max);
    }

}