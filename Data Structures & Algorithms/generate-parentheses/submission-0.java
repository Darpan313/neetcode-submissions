class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        gp(sb, 0, 0, n, res);
        return res;
    }

    public void gp(StringBuilder sb, int open, int close, int n, List<String> res) {
        if(open == n && close == n) {
            res.add(sb.toString());
            return;
        }
        if(open<close || open>n) {
            return;
        }

        sb.append('(');
        gp(sb, open+1, close, n, res);
        sb.deleteCharAt(sb.length()-1);
        sb.append(')');
        gp(sb, open, close+1, n, res);
        sb.deleteCharAt(sb.length()-1);
    }
}
