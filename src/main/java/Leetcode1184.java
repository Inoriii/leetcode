package main.java;

import java.util.Arrays;

/**
 * @author sakura
 */
public class Leetcode1184 {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (distance == null || distance.length == 0 || start == destination) {
            return 0;
        }
        int myStart, myEnd;
        myStart = Math.min(start, destination);
        myEnd = Math.max(start, destination);
        int sum = Arrays.stream(distance).sum();
        int ans = 0;
        for (int i = myStart; i < myEnd; ++i) ans += distance[i];
        return Math.min(ans, sum - ans);
    }

}