class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> freq = new HashMap<>();
        for(char c: s1.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i < s2.length(); i++){
            if(i < s1.length()){
                freq.put(s2.charAt(i), freq.getOrDefault(s2.charAt(i), 0) + 1);
            } else {
                freq.put(s2.charAt(i - s1.length()), freq.get(s2.charAt(i - s1.length())) - 1);
                if(freq.get(s2.charAt(i - s1.length())) <= 0){
                    freq.remove(s2.charAt(i - s1.length()));
                }
                freq.put(s2.charAt(i), freq.getOrDefault(s2.charAt(i), 0) + 1);
            }
            if(map.equals(freq)) return true;
        }
        return false;
    }
}
