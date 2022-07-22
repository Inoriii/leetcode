package main.java.util;

import main.java.common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ListNodeUtil {
    public static ListNode array2Tree(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        ListNode start = new ListNode();
        doArray2ListNode(array, start);
        return start.next;
    }

    public static List<Integer> listNode2List(ListNode node) {
        if (node == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        return list;
    }


    private static void doArray2ListNode(int[] array, ListNode start) {
        for (int i : array) {
            start.next = new ListNode(i);
            start = start.next;
        }
    }
}
