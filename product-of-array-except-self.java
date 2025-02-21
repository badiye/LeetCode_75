class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;        
        //new array for result     
        int[] answer = new int[nums.length];
        // initialize prefix and sufffix product for the first and last numbers
        int prefix = 1, suffix = 1;
        answer[0] = prefix;

        //calculate prefix products for the rest of the array
        for(int i=1; i<n; i++) {
            prefix *= nums[i-1];
            answer[i] = prefix;
        }
        //calculate suffix products and multiply with prefix products
        for(int i=n-2; i>=0; i--) {
            suffix *= nums[i+1];
            answer[i] *= suffix;
        }
               
        return answer;
    }
}