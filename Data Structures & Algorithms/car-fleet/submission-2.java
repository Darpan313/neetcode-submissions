class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int fleet = 0;
        if(position.length==0) {
            return fleet;
        }
        TreeMap<Integer, Double> positionTime = new TreeMap<>((a,b)-> Integer.compare(b,a));
        for(int i=0; i<position.length; i++) {
            positionTime.put(position[i], (target-position[i])*1.0/speed[i]);
        }

        int first = 0;
        double previous = 0.0;
        double current = 0.0;
        for(Map.Entry<Integer, Double> entry:positionTime.entrySet()) {
            current = entry.getValue();
            if(first==0) {
                previous = current;
                first++;
                continue;
            }
            if(current>previous) {
                fleet++;
                previous = current;
            }
        }
        return fleet+1;
    }
}
