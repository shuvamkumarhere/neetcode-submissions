class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        while(left < right){
            char chL = s.charAt(left), chR = s.charAt(right);
            while(!((chL >= '0' && chL <= '9') || (chL >= 'A' && chL <= 'Z') || (chL >= 'a' && chL <= 'z')) && left < right){
                left++;
                chL = s.charAt(left);
            }
            while(!((chR >= '0' && chR <= '9') || (chR >= 'A' && chR <= 'Z') || (chR >= 'a' && chR <= 'z')) && left < right){
                right--;
                chR = s.charAt(right);
            }
            if(chR == chL){
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
