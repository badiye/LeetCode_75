class Solution {
    public String decodeString(String s) {
        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        
        StringBuilder currentString = new StringBuilder();
        int k = 0; 

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                numStack.push(k);
                strStack.push(currentString.toString());
                currentString = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                int repeatCount = numStack.pop();
                String previousString = strStack.pop();
                StringBuilder temp = new StringBuilder(previousString);
                for (int i = 0; i < repeatCount; i++) {
                    temp.append(currentString);
                }
                currentString = temp;
            } else {
                currentString.append(c);
            }
        }
        
        return currentString.toString();
    }
}
