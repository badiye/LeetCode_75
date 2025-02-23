class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int currentVowelCount = 0;
        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                currentVowelCount++;
            }
        }
        int maxVowelCount = currentVowelCount;
        for (int i = k; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i - k))) {
                currentVowelCount--;
            }
            if (vowels.contains(s.charAt(i))) {
                currentVowelCount++;
            }
            maxVowelCount = Math.max(maxVowelCount, currentVowelCount);
        }
        return maxVowelCount;
    }
}
