class Solution {
    int n, k;
    public int subsetXORSum(int[] nums) {
        int sum = 0;
        n=nums.length;
        for(k=1; k<=n;k++) {
            sum+=XOR(0, nums, new ArrayList());
        }
        return sum;
    }

    public int XOR(int first, int[] nums, List<Integer> curr) {
        int sum = 0;
        if(curr.size()==k) {
            int s = 0;
            for(int j=0;j<curr.size();j++) {
                s=curr.get(j)^s;
            } 
            return s;
        }

        for(int i=first; i<n;i++) {
            curr.add(nums[i]);
            sum+=XOR(i+1, nums, curr);
            curr.remove(curr.size()-1);
        }
        return sum;
    }
}