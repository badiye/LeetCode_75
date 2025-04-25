import java.util.*;
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        
        String prefix = "";
        for (char ch : searchWord.toCharArray()) {
            prefix += ch;
            List<String> suggestions = new ArrayList<>();

            int start = binarySearch(products, prefix);
            for (int i = start; i < products.length && suggestions.size() < 3; i++) {
                if (products[i].startsWith(prefix)) {
                    suggestions.add(products[i]);
                } else {
                    break;
                }
            }
            result.add(suggestions);
        }
        
        return result;
    }

    private int binarySearch(String[] products, String prefix) {
        int low = 0, high = products.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (products[mid].compareTo(prefix) < 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
