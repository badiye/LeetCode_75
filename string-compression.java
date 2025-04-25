class Solution {
    public int compress(char[] chars) {
        int i = 0, j = 0;
        while (i < chars.length) {
            char current = chars[i];
            int count = 0;
            while (i < chars.length && chars[i] == current) {
                count++;
                i++;
            }
            chars[j] = current;
            j++;
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[j] = c;
                    j++;
                }
            }
        }

        return j;
    }
}