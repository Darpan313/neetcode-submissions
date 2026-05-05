class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for(int num:nums) {
            set.add(num);
        }
        for(int i=0; i<nums.length; i++) {
            if(!set.contains(nums[i]-1)) {
                int currStreak = 1;
                int currNum = nums[i];
                while(set.contains(currNum+1)) {
                    currStreak++;
                    currNum++;
                }
                max = Math.max(max, currStreak);
            }
        }
        return max;
    }
}
