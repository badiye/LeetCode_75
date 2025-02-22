public class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (j < t.length()) {
            if (i < s.length() && s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}
