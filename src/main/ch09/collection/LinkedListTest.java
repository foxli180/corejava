package ch09.collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListTest {

    public static void main(String[] args) {
        List<String> a = new LinkedList<>();
        a.add("amy");
        a.add("carl");
        a.add("Eric");

        List<String> b = new LinkedList<>();
        b.add("bob");
        b.add("Dong");
        b.add("france");
        b.add("gloria");


        ListIterator aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        while (bIter.hasNext()) {
            if (aIter.hasNext()) {
                aIter.next();
            }
            aIter.add(bIter.next());
        }
        System.out.println(a);
        System.out.println(b);
        bIter = b.iterator();
        while (bIter.hasNext()) {
            bIter.next();
            if (bIter.hasNext()) {
                bIter.next();
                bIter.remove();
            }
        }
        System.out.println(b);
        System.out.println(a);
        a.removeAll(b);
        System.out.println(a);
    }
}
