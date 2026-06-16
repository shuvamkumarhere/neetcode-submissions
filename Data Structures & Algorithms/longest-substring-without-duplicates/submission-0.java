class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = 0, n = s.length(), maxLength = 0;
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(i - length));
                length--;
            }
            set.add(s.charAt(i));
            length++;
            maxLength = Math.max(length, maxLength);
        }
        return maxLength;
    }
}
