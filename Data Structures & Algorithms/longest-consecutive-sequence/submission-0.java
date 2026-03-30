class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for( int n : nums) {
            if(!map.containsKey(n)) {
                int left = map.getOrDefault(n-1,0);
                int right = map.getOrDefault(n+1,0);
                int curr = left+ right+1;
                map.put(n, curr);
                if(curr > res) res = curr;
                map.put(n-left, curr);
                map.put(n+right, curr);
            } else {
                continue;
            }
        }
        return res;
    }
}
