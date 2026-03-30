class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       List<List<String>> result = new ArrayList<List<String>>();
       Map<String,  List<String>> map = new HashMap<String, List<String>>();
       for(int i=0;i<strs.length;i++) {
            int[] count = new int[26];
            for(int j = 0;j<strs[i].length();j++) {
                count[strs[i].charAt(j)-'a']++;
            }
            String key = Arrays.toString(count);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}
