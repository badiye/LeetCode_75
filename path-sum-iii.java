import java.util.HashMap;

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1); 
        return dfs(root, targetSum, 0, prefixSumCount);
    }
    private int dfs(TreeNode node, int targetSum, long currentSum, HashMap<Long, Integer> prefixSumCount) {
        if (node == null) {
            return 0;
        }
        currentSum += node.val;
        int result = prefixSumCount.getOrDefault(currentSum - targetSum, 0);
        prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);

        result += dfs(node.left, targetSum, currentSum, prefixSumCount);
        result += dfs(node.right, targetSum, currentSum, prefixSumCount);

        prefixSumCount.put(currentSum, prefixSumCount.get(currentSum) - 1);
        
        return result;
    }
}