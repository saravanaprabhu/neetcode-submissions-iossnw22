class Solution {
    public int trap1(int[] height) {
        int prefix[] = new int[height.length];
        int suffix[] = new int[height.length];
        int result = 0;
        prefix[0] = height[0];
        suffix[height.length-1] = height[height.length-1];
        for(int i=1;i<height.length;i++) {
            prefix[i] = Math.max(prefix[i-1], height[i]); 
        }
        for(int i=height.length-2;i >=0 ;i--) {
            suffix[i] = Math.max(suffix[i+1], height[i]); 
        }

        for(int i = 0 ; i< height.length;i++) {
            result = result + Math.min(prefix[i],suffix[i]) - height[i];
        }
        return result;
    }


    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int l = 0 ,r = height.length-1;
        int res = 0;
        int leftMax = height[l], rightMax =height[r];
        while(l < r) {
            if(leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                res += leftMax - height[l];
            } else {
                r--;
                rightMax =Math.max(rightMax, height[r]);
                res+=rightMax - height[r];
            }
        }
        return res;
    }
}
