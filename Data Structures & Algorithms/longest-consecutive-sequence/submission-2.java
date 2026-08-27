class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int result = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            if(map.get(nums[i]) == null) {
                int left = map.getOrDefault(nums[i]-1, 0);
                int right = map.getOrDefault(nums[i] + 1, 0);
                int currentSeq =  left+right+1;
                if(currentSeq > result) {
                    result = currentSeq;
                }
                map.put(nums[i], currentSeq);
                map.put(nums[i]-left , currentSeq);
                map.put(nums[i]+right, currentSeq);
            }
        }
        return result;
    }
}
