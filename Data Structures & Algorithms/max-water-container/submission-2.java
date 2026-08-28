class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int l = 0, r = heights.length-1;
        while( l < r) {
            int currentminHeight = Math.min(heights[l], heights[r]);
            
            int currArea = currentminHeight * (r-l);
            if(maxArea < currArea) {
                maxArea = currArea;
            }
            if(heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        } 
        return maxArea;
    }
}
