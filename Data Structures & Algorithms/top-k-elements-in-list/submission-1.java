class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int maxFreq = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++) {
            int freq = map.getOrDefault(nums[i],0) + 1;
            if(freq > maxFreq) {
                maxFreq = freq;
            }
            map.put(nums[i] , freq);
        }
        List<Integer>[] freqList = new List[maxFreq+1];
        for(int i=0;i <= maxFreq ; i++) {
            freqList[i] = new ArrayList<>();
        }
        for(Map.Entry<Integer, Integer> eachEntry : map.entrySet()) {
            freqList[eachEntry.getValue()].add(eachEntry.getKey());
        }
        int[] result = new int[k];
        int count = 0;
        for(int i = maxFreq; i > 0 && count < k ; i-- ) {
            if(freqList[i].size() > 0) {
                for(Integer eachElement: freqList[i]) {
                    if(count < k) {
                        result[count++] = eachElement;
                    } else {
                        break;
                    }
                }
            }
        }
        return result;
    }
}
