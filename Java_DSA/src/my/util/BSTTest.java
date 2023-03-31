package my.util;

import org.junit.Test;

public class BSTTest {
    public static void testDelete() {
        ST<String, Integer> bst = new BST<>();
        bst.put("S", 1);
        bst.put("E", 2);
        bst.put("A", 3);
        bst.put("C", 4);
        bst.put("R", 5);
        bst.put("H", 6);
        bst.put("M", 7);
        bst.put("X", 8);

        System.out.println(bst.size());
        bst.pop("E");
        System.out.println(bst.size());
    }
}
