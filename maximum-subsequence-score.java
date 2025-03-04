import java.util.*;

class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums2[i];
            pairs[i][1] = nums1[i];
        }
        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);

        // Initialize min heap and variables
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0;
        long maxScore = 0;

        for (int[] pair : pairs) {
            int num2 = pair[0];
            int num1 = pair[1];

            // Add num1 to the heap and update sum
            minHeap.offer(num1);
            sum += num1;

            // If heap size exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                sum -= minHeap.poll();
            }

            // If heap size is k, calculate and update max score
            if (minHeap.size() == k) {
                maxScore = Math.max(maxScore, sum * num2);
            }
        }

        return maxScore;
    }
}