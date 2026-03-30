class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        if(nums == null || nums.length == 0) return new ArrayList<>(result);
        
        for(int i=0;i<nums.length;i++) {
            int l = i+1, r = nums.length-1;
            while(l < r) {
                if(nums[l] + nums[r] == -nums[i]) {
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(nums[i]);
                    tmp.add(nums[l]);
                    tmp.add(nums[r]);
                    result.add(tmp); 
                    l++;r--;
                } else if(nums[l] + nums[r] < -nums[i]) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return new ArrayList<>(result);
    }
}
