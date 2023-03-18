package main.java;

class LeetCode1616 {
    public static boolean checkPalindromeFormation(String a, String b) {
        if (a == null || b == null || a.length() == 0 || b.length() == 0 || a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
           if(checkPalindromeFormation(a, b, i)||checkPalindromeFormation(b, a, i)) {
               return true;
           }
        }
        return false;
    }

    private static boolean checkPalindromeFormation(String a, String b, int position) {
        int l = 0, r = a.length() - 1;
        boolean isPalindromeFormation = true;

        while (l < r) {
            if (l < position && r >= position) {
                if (a.charAt(l) != b.charAt(r)) {
                    isPalindromeFormation = false;
                    break;
                }
            } else if (l >= position) {
                if (b.charAt(l) != b.charAt(r)) {
                    isPalindromeFormation = false;
                    break;
                }
            }   else {
                if (a.charAt(l) != a.charAt(r)) {
                    isPalindromeFormation = false;
                    break;
                }
            }
            ++l;
            --r;
        }
        return isPalindromeFormation;
    }


    public static void main(String[] args) {
       String  a = "ulacfd", b = "jizalu";
        boolean ans = checkPalindromeFormation(a, b);
        System.out.println(ans);
    }
}