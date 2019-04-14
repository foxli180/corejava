package ch09.collection;

import com.sun.nio.sctp.SctpStandardSocketOptions;
import groovy.util.logging.Slf4j;
import org.testng.annotations.Test;

import java.util.*;

public class TreeSetTest {


    @Test
    public void testTreeSet() {
        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("Toaster", 1234));
        parts.add(new Item("Widget", 4562));
        parts.add(new Item("Moden", 9912));
        System.out.println(parts);

        NavigableSet<Item> sortByDescription = new TreeSet<>(Comparator.comparing(Item::getDescription));
        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);

    }

    private class Item implements Comparable<Item> {
        private String description;
        private int aPartNumber;

        public Item(String description, int aPartNumber) {
            this.description = description;
            this.aPartNumber = aPartNumber;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return "[desciption=" + description + ", partNumber=" + aPartNumber + "]";
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (this.getClass() != obj.getClass()) return false;
            Item other = (Item) obj;
            return Objects.equals(description, other.description) && this.aPartNumber == other.aPartNumber;
        }

        @Override
        public int hashCode() {
            return Objects.hash(description, aPartNumber);
        }

        @Override
        public int compareTo(Item other) {
            int diff = Integer.compare(aPartNumber, other.aPartNumber);
            return diff != 0? diff: description.compareTo(other.description);
        }
    }
}
