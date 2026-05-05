class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> parenthesisMap = new HashMap<>();
        parenthesisMap.put('(', ')');
        parenthesisMap.put('{', '}');
        parenthesisMap.put('[', ']');

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else if(c == ')' || c == '}' || c == ']') {
                if(stack.isEmpty()) {
                    return false;
                }
                char topElement = stack.pop();
                //topElement should be complementary closing bracket
                if(parenthesisMap.get(topElement) != c) {
                    return false;
                }
            }
            else {
                System.exit(1);
            }
        }
        return stack.isEmpty();
    }
}
