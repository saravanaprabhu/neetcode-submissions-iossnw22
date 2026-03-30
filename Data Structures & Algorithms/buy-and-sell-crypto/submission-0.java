class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int max = 0;
        int min = prices[0];
        for(int i=1;i<prices.length;i++) {
            int currProfit = prices[i] - min;
            if(currProfit > max) max = currProfit;
            if(prices[i] < min) {
                min = prices[i];
            }
        }
        return max;
    }
}
