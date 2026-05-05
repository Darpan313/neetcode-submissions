class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> original = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        int l = temperatures.length;
        int[] res = new int[l];
        
        for(int i=l-1;i>=0;i--) {
            original.push(temperatures[i]);
        }
        int i =0;
        while(!original.isEmpty()) {
            int current = original.pop();
            while(!original.isEmpty()) {
                int next = original.pop();
                int days = 0;
                if(next<=current) {
                    temp.push(next);
                }
                else {
                    original.push(next);
                    days++;
                    while(!temp.isEmpty()) {
                        original.push(temp.pop());
                        days++;
                    }
                    res[i] = days;
                    break;
                }
            }
             while(!temp.isEmpty()) {
                original.push(temp.pop());
            }
            i++;
        }
        return res;
    }
}
