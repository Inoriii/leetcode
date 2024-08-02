package main.java;

import java.util.HashSet;
import java.util.Set;

class LeetCode1625 {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> numSet = new HashSet<>();
        int n = s.length();
        for (int i = 1; i < n; i += 2) {
            numSet.add(s);
            s = add(s, a, i);
            while (!numSet.contains(s)) {
                numSet.add(s);
                s = add(s, a, i);
            }
        }
        String ans = null;
        Set<String> addSet = new HashSet<>();
        for (String ss : numSet) {
            if(ans==null) ans=ss;
            addSet.add(ss);
            ss = ip(ss, b);
            while (!addSet.contains(ss)) {
                addSet.add(ss);
                if (ans.compareTo(ss) > 0) {
                    ans = ss;
                }
                ss = ip(ss, b);
            }
        }
        return ans;
    }

    private String ip(String ss, int b) {
        int n = ss.length();
        ss += ss;
        return ss.substring(b, n + b);
    }

    public static String add(String s, int a, int i) {
        char[] chars = s.toCharArray();
        chars[i] = (char) ((chars[i] - '0' + a) % 10 + '0');
        return new String(chars);
    }


    public static void main(String[] args) {
        String s = "5525";
        int a = 9, b = 2;
        LeetCode1625 l = new LeetCode1625();
        String ans = l.findLexSmallestString(s, a, b);
        System.out.println(ans);
    }
}