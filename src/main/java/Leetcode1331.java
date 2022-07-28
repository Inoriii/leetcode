package main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sakura
 */
public class Leetcode1331 {

    public int[] arrayRankTransform(int[] arr) {
        int[] sortedArr = new int[arr.length];
        System.arraycopy(arr, 0, sortedArr, 0, arr.length);
        Arrays.sort(sortedArr);
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for (int i : sortedArr) {
            if (map.get(i) == null) {
                map.put(i, ++index);
            }
        }
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }

}