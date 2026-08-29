class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }
        int l = 1, r = max;
        int result = max;
        while( l <= r) {
            int mid = l + (r-l)/2;
            int count = 0;
            for(int i = 0; i < piles.length;i++) {
                count+= (int) Math.ceil((double)piles[i]/mid);
            }
            if(count <=h) {
                result = Math.min(mid, result);
                r = mid -1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }
}
