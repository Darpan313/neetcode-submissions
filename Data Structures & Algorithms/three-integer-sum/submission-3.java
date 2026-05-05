class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++) {
            if(i!=0 && nums[i]==nums[i-1]){
                continue;
            }
            int start = i+1;
            int end = nums.length-1;
            while(start<end) {
                if(nums[start]+nums[end]+nums[i]==0) {
                    list.add(List.of(nums[start], nums[end], nums[i]));
                    while(start<end && (nums[start]==nums[start+1])) {
                        start++;
                    }
                    while(start<end && (nums[end]==nums[end-1])) {
                        end--;
                    }
                    start++;
                    end--;
                }
                else if(nums[start]+nums[end]+nums[i]>0) {
                    end--;
                }
                else {
                    start++;
                }
            }
        }
        return list;
    }
}
