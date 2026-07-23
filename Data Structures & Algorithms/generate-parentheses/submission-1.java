class Solution {
    private void solve(int n, List<String> result, StringBuilder sb, int openCount, int closeCount){
        if(sb.length() == 2 * n){
            result.add(sb.toString());
            return;
        }
        if(openCount < n){
            solve(n, result, sb.append("("), openCount + 1, closeCount);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(closeCount < openCount){
            solve(n, result, sb.append(")"), openCount, closeCount + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        solve(n, result, new StringBuilder(), 0, 0);
        return result;
    }
}
