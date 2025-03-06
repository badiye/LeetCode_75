class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[mid + 1]) {
                right = mid; // Peak is on the left side
            } else {
                left = mid + 1; // Peak is on the right side
            }
        }

        return left; // Peak index
    }
}
