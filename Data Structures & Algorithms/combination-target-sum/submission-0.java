class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backtrack(0, nums, target, new ArrayList<Integer>(), result);
        return result;
    }


    void backtrack(int index,  int[] nums, int target, List<Integer> tmp, List<List<Integer>> result) {
        if(target == 0) {
            result.add(new ArrayList<Integer>(tmp));
            return;
        }
        if(target < 0) {
            return;
        }

        for(int i = index; i< nums.length; i++) {
            tmp.add(nums[i]);
            backtrack(i, nums, target - nums[i], tmp, result);
            tmp.remove(tmp.size()-1);
        }
    }
}
