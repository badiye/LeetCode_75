class Solution {
    public String reverseVowels(String s) {
        char[] word = s.toCharArray();
        String vowels = "AaEeIiOoUu";
        int left = 0;
        int right = s.length() - 1;
        while(left<right) {
            if(vowels.indexOf(word[left]) == -1) {
                left++;
            }
            if(vowels.indexOf(word[right]) == -1) {
                right--;
            }
            if(vowels.indexOf(word[left]) != -1 && vowels.indexOf(word[right]) != -1) {
                char temp = word[left];
                word[left] = word[right];
                word[right] = temp;
                left++;
                right--;
            }
        }
        return new String(word);
        
    }
}