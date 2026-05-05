class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        backtrack(new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    public void backtrack(List<Integer> curr, int[] nums, boolean[] pick) {
        if(curr.size()==nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(!pick[i]) {
                curr.add(nums[i]);
                pick[i] = true;
                backtrack(curr, nums, pick);
                curr.remove(curr.size()-1);
                pick[i] = false;
            }
        }
    }
}
