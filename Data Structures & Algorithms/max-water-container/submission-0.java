class Solution {
    public int maxArea(int[] heights) {
        if(heights== null || heights.length ==  0) return 0;
        int l = 0, r =heights.length-1;
        int maxArea = 0;
        while(l < r) {
            int currArea = (r-l)*Math.min(heights[l],heights[r]);
            if(currArea > maxArea) maxArea = currArea;
            if(heights[l] < heights[r]){
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
}
