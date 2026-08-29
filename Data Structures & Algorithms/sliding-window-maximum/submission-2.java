class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<Integer>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0 ; i < k ; i ++) {
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        result.add(nums[dq.peekFirst()]);
        for(int i = k ; i < nums.length; i++) {
            //remove the out indices out of window
            while (!dq.isEmpty() && i - k == dq.peekFirst()) {
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            result.add(nums[dq.peekFirst()]);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
