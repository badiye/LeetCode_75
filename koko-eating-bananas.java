import java.util.Arrays;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = Arrays.stream(piles).max().getAsInt(); // Max pile size

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, h, mid)) {
                right = mid; // Try a smaller speed
            } else {
                left = mid + 1; // Increase speed
            }
        }
        return left;
    }

    private boolean canFinish(int[] piles, int h, int k) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + k - 1) / k; // Equivalent to ceil(pile / k)
        }
        return hours <= h;
    }
}
