class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int k;
    public List<List<Integer>> subsets(int[] nums) {
        for(k=0; k<nums.length+1; k++) {
            subsetOfLengthK(0, nums, new ArrayList<Integer>());
        }
        return res;
    }

    public void subsetOfLengthK(int first, int[] nums, List<Integer> curr){
        if(curr.size() == k) {
            res.add(new ArrayList(curr));
        }
        for(int i=first; i<nums.length; i++) {
            curr.add(nums[i]);
            subsetOfLengthK(i+1, nums, curr);
            curr.remove(curr.size()-1);
        }
    }
}
