class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backtrack(0, nums, new ArrayList(), result);
        return result;
    }

    void backtrack(int index, int[] nums, List<Integer> tmp, List<List<Integer>> result) {
        result.add(new ArrayList<>(tmp));
        for(int i = index; i< nums.length;i++) {
            tmp.add(nums[i]);
            backtrack(i+1, nums, tmp, result);
            tmp.remove(tmp.size()-1);
        }
    }
}
