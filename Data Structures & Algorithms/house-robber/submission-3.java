class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        return rob_dp_topDown(nums, dp, 0);
    }

    public int rob(int[] nums, int index) {
        if(index >= nums.length) return 0;
        return Math.max(nums[index]+ rob(nums, index+2), rob(nums,index+1));
    } 

    public int rob_dp(int[] nums, int[] dp, int index) {
        if(dp[index] != -1) return dp[index];
        if(index >= nums.length) return 0;
        int val1 = nums[index]+ rob(nums, index+2);
        int val2 = rob(nums, index+1);
        dp[index] = Math.max(val1, val2);
        return dp[index];
    } 


    public int rob_dp_topDown(int[] nums, int[] dp, int index) {
        dp[0] = nums[0];
        if(nums.length > 1) {
            dp[1] = Math.max(nums[0], nums[1]);
        }
        //dp[2] = Math.max(nums[0] + nums[2] , nums[1]);
        for(int i=2; i<nums.length;i++) {
            dp[i] = Math.max(nums[i] + dp[i-2] , dp[i-1]);
        }
        return dp[nums.length-1];
    } 
}
