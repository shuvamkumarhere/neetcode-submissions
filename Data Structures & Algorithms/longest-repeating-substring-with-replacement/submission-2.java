class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length(), maxLength = 0;
        int left = 0, maxFreq = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int right = 0; right < n; right++){
            Character rightChar = s.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
            if(map.get(rightChar) > maxFreq){
                maxFreq = map.get(rightChar);
            }
            int length = right - left + 1;
            if(length - maxFreq <= k){
                maxLength = Math.max(maxLength, length);
            } else {
                Character leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }
        }
        return maxLength;
    }
}
