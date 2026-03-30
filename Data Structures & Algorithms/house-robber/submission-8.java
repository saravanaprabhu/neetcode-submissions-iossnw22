class Solution {
    public int rob(int[] nums) {
        return rob_dp_topDown(nums);
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


    public int rob_dp_topDown(int[] nums) {
        int first = nums[0];
        int second = 0;
        if(nums.length > 1) {
           second = Math.max(nums[0], nums[1]);
        }
        //dp[2] = Math.max(nums[0] + nums[2] , nums[1]);
        for(int i=2; i<nums.length;i++) {
            int temp = Math.max(nums[i] + first , second);
            first = second;
            second = temp;

        }
        return Math.max(first, second);
    } 
}
