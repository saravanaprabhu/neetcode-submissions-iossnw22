class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        Arrays.sort(candidates);
        backtrack(0, candidates, target, new ArrayList<Integer>(), result);
        return new ArrayList<>(result);
    }

    void backtrack(int index,  int[] nums, int target, List<Integer> tmp, Set<List<Integer>> result) {
        if(target == 0) {
            result.add(new ArrayList<Integer>(tmp));
            return;
        }
        if(target < 0) {
            return;
        }

        for(int i = index; i< nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            tmp.add(nums[i]);
            backtrack(i+1, nums, target - nums[i], tmp, result);
            tmp.remove(tmp.size()-1);
        }
    }
}
