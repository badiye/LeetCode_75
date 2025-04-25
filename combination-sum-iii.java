import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> combination, int k, int target, int start) {
        if (combination.size() == k && target == 0) {
            result.add(new ArrayList<>(combination)); 
            return;
        }
        
        for (int i = start; i <= 9; i++) {
            if (i > target) break; 
            
            combination.add(i);
            backtrack(result, combination, k, target - i, i + 1); 
            combination.remove(combination.size() - 1); 
        }
    }

}
