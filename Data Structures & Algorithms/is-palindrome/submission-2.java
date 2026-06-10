class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while(left < right){
            char chL = s.charAt(left), chR = s.charAt(right);
            chR = Character.toLowerCase(chR); chL = Character.toLowerCase(chL);
            while(!((chL >= '0' && chL <= '9') || (chL >= 'a' && chL <= 'z')) && left < right){
                left++;
                chL = Character.toLowerCase(s.charAt(left));
            }
            while(!((chR >= '0' && chR <= '9') || (chR >= 'a' && chR <= 'z')) && left < right){
                right--;
                chR = Character.toLowerCase(s.charAt(right));
            }
            if(Character.toLowerCase(chR) == Character.toLowerCase(chL)){
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
