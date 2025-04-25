import java.util.*;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> nums1set = new HashSet<>();
        Set<Integer> nums2set = new HashSet<>();
        
        for (int num : nums1) {
            nums1set.add(num);
        }
        for (int num : nums2) {
            nums2set.add(num);
        }
        
        Set<Integer> onlynums1 = new HashSet<>(nums1set);
        onlynums1.removeAll(nums2set);         
        Set<Integer> onlynums2 = new HashSet<>(nums2set);
        onlynums2.removeAll(nums1set); 
        
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>(onlynums1));
        answer.add(new ArrayList<>(onlynums2));
        
        return answer;
    }
}
