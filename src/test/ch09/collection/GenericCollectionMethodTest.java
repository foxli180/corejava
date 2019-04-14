package ch09.collection;

import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class GenericCollectionMethodTest {

    @Test
    public void test_1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("Test");
        arrayList.add("Good");
        assertEquals(GenericCollectionMethod.contains(arrayList,"Test"), true);
    }
}