import java.util.PriorityQueue;

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        long totalCost = 0;
        
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();
        
        int left = 0, right = n - 1;
        
        // Fill left heap with first `candidates` workers
        for (int i = 0; i < candidates && left <= right; i++) {
            leftHeap.add(costs[left++]);
        }

        // Fill right heap with last `candidates` workers (ensure no overlap)
        for (int i = 0; i < candidates && left <= right; i++) {
            rightHeap.add(costs[right--]);
        }

        // Hiring process
        while (k-- > 0) {
            if (rightHeap.isEmpty() || (!leftHeap.isEmpty() && leftHeap.peek() <= rightHeap.peek())) {
                // Hire from left heap
                totalCost += leftHeap.poll();
                if (left <= right) leftHeap.add(costs[left++]); // Expand from left
            } else {
                // Hire from right heap
                totalCost += rightHeap.poll();
                if (left <= right) rightHeap.add(costs[right--]); // Expand from right
            }
        }

        return totalCost;
    }
}
