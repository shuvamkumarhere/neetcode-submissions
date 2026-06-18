class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int requiredChars = t.length();
        int left = 0;

        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;

        for (int right = 0; right < s.length(); right++) {

            char rightChar = s.charAt(right);

            if (map.getOrDefault(rightChar, 0) > 0) {
                requiredChars--;
            }

            map.put(
                rightChar,
                map.getOrDefault(rightChar, 0) - 1
            );

            while (requiredChars == 0) {

                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);

                map.put(
                    leftChar,
                    map.getOrDefault(leftChar, 0) + 1
                );

                if (map.get(leftChar) > 0) {
                    requiredChars++;
                }

                left++;
            }
        }

        return minLength == Integer.MAX_VALUE
                ? ""
                : s.substring(startIndex, startIndex + minLength);
    }
}