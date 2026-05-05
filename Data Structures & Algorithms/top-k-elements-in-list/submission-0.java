class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> numCount = new HashMap<>();

        for(int n : nums) {
            numCount.put(n, numCount.getOrDefault(n,0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> 
            a.getValue().equals(b.getValue()) ? Integer.compare(b.getKey(), a.getKey()) : 
            Integer.compare(b.getValue(), a.getValue())); 

        for(Map.Entry<Integer,Integer> entry : numCount.entrySet()) {
            pq.offer(entry);
        }

        for(int i=0; i<k; i++) {
            result[i] = pq.poll().getKey();
        }

        return result;
    }
}
