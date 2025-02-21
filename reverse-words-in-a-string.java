class Solution {
    public String reverseWords(String s) {
        //trim white space and split words to Array
        String[] wordsArr = s.trim().split("\\s+");
        //reverse the array and build the string    
        StringBuilder reversed = new StringBuilder();
        for(int i=wordsArr.length-1; i>=0; i--) { 
            reversed.append(wordsArr[i]);
            if(i!=0) {
                reversed.append(" ");
            }
        }
    return reversed.toString();
    }
}