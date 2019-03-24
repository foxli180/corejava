package test.ch08.generic;

import main.ch08.generic.ArrayAlg;
import org.testng.annotations.Test;

import javax.swing.*;

import static org.testng.Assert.*;

public class ArrayAlgTest {

    @Test
    public void test_With_String() {
        assertEquals(ArrayAlg.getMiddle("Hello", "Q","TEst"), "Q");
    }

    @Test
    public void test_with_Integer() {
        assertEquals(ArrayAlg.getMiddle(3.14, 1222, 0), 1222);
    }

    @Test(expectedExceptions = ClassCastException.class)
    public void test_with_Exception(){
        JButton jButton = (JButton) ArrayAlg.getMiddle("Hello", 0 , null);
//        assertEquals(ArrayAlg.getMiddle(3.14, "Hello", null) ,"Hello");
    }
}