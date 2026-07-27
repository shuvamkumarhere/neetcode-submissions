class Solution {
    List<String> map = new ArrayList<>(List.of("abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"));
    private void solve(String digits, List<String> result, int idx, StringBuilder sb){
        if(idx == digits.length()){
            result.add(sb.toString());
            return;
        }
        int digit = digits.charAt(idx) - '0';
        for(int i = 0; i < map.get(digit - 2).length(); i++){
            sb.append(map.get(digit - 2).charAt(i));
            solve(digits, result, idx + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        solve(digits, result, 0, new StringBuilder());
        return result;
    }
}
