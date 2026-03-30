class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        if(nums == null ||nums.length == 0) return false;
        for(int i=0;i<nums.length;i++) {
            if(set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
