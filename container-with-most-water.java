class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int h= Math.min(height[i], height[j]);
        int Area = h*j;
        while(i<j) {
            if(height[i]<height[j]) {
                i++;
            } else {
                j--;
            }
            int hg=Math.min(height[i], height[j]);
            int A = hg*(j-i);
            if(A>Area) {
                Area = A;
            }
        }
    return Area;    
    }
}