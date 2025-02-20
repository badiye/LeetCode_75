class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int i=0, j=0;
        //continue until both strings end
        while( i<word1.length() || j<word2.length()) {
            //one from str1
            if(i<word1.length()) {
                result.append(word1.charAt(i));
                i++;
            }
            //one from str2
            if(j<word2.length()) {
                result.append(word2.charAt(j));
                j++;
            }
        }
    //change to string and merge
    String merged = result.toString();
    return merged;
    }
}