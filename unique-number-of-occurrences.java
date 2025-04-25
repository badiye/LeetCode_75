import java.util.HashMap;

public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int count : map.values()) {
            if (countMap.containsKey(count)) {
                return false;
            }
            countMap.put(count, 1);
        }
        return true;
    }
}