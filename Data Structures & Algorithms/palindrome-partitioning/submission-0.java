class Solution {
    private boolean isPalindrome(String s){
        int right = s.length() - 1;
        int left = 0;
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    private void solve(String s, List<String> strList, List<List<String>> result, int idx){
        if(idx == s.length()){
            result.add(new ArrayList<>(strList));
            return;
        }
        for(int i = idx; i < s.length(); i++){
            String str = s.substring(idx, i + 1);
            if(isPalindrome(str)){
                strList.add(str);
                solve(s, strList, result, i + 1);
                strList.remove(strList.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        solve(s, new ArrayList<>(), result, 0);
        return result;
    }
}
