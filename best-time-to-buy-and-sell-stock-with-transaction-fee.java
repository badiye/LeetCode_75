class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int hold = -prices[0];
        int cash = 0;
        for (int i = 1; i < n; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }
}