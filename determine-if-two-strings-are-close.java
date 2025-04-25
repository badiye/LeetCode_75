import java.util.*;
class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        Hashtable<Character, Integer> freq1 = new Hashtable<>();
        Hashtable<Character, Integer> freq2 = new Hashtable<>();
        for (char c : word1.toCharArray()) {
            freq1.put(c, freq1.getOrDefault(c, 0) + 1);
        }
        for (char c : word2.toCharArray()) {
            freq2.put(c, freq2.getOrDefault(c, 0) + 1);
        }
        if (!freq1.keySet().equals(freq2.keySet())) {
            return false;
        }
        List<Integer> freqList1 = new ArrayList<>(freq1.values());
        List<Integer> freqList2 = new ArrayList<>(freq2.values());
        Collections.sort(freqList1);
        Collections.sort(freqList2);
        return freqList1.equals(freqList2);
    }
}