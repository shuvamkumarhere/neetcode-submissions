class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for(String str: strs){
            char [] carr = str.toCharArray();
            Arrays.sort(carr);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < carr.length; i++){
                sb.append(carr[i]);
            }
            String newString = sb.toString();
            map.putIfAbsent(newString, new ArrayList<>());
            map.get(newString).add(str);
        }
        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }
}
