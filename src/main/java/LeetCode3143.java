package main.java;

import java.util.*;

class LeetCode3143 {
    public static int maxPointsInsideSquare(int[][] points, String s) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.computeIfAbsent(Math.max(Math.abs(points[i][0]), Math.abs(points[i][1])), x -> new ArrayList<>()).add(i);
        }
        Set<Character> set = new HashSet<>();
        int ans = 0;
        while (!map.isEmpty()) {
            List<Integer> list = map.pollFirstEntry().getValue();
            for (int i = 0; i < list.size(); i++) {
                char c = s.charAt(list.get(i));
                if (set.contains(c)) {
                    return ans;
                } else {
                    set.add(c);
                }
            }
            ans += list.size();
        }
        return ans;
    }


    public static void main(String[] args) {
        int[][] points1 = new int[][]{{2, 2}, {-1, -2}, {-4, 4}, {-3, 1}, {3, -3}};
        String s1 = "abdca";
        int[][] points2 = new int[][]{{1, 1}, {-2, -2}, {-2, 2}};
        String s2 = "abb";
        int[][] points3 = new int[][]{{1, 1}, {-1, -1}, {2, -2}};
        String s3 = "ccd";
        int i1 = maxPointsInsideSquare(points1, s1);
        int i2 = maxPointsInsideSquare(points2, s2);
        int i3 = maxPointsInsideSquare(points3, s3);
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);
    }
}