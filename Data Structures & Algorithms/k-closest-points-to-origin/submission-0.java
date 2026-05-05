class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        PriorityQueue<Pair<Integer,Double>>  pq = 
        new PriorityQueue<>((a,b)->Double.compare(a.getValue(),b.getValue()));
        int i=0;
        for(int[] p : points){
            int x = p[0];
            int y = p[1];

            double d = Math.hypot(x, y);;
            pq.offer(new Pair<>(i,d));
            i++;
        }

        for(int j=0; j<k; j++){
            Pair<Integer,Double> p = pq.remove();
            res[j] = points[p.getKey()];
        }
        return res;
    }
}
