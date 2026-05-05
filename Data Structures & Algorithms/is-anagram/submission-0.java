class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> countMap = new HashMap<>();
        for(int i=0; i<t.length(); i++) {
            countMap.put(s.charAt(i), countMap.getOrDefault(s.charAt(i), 0)+1);
            countMap.put(t.charAt(i), countMap.getOrDefault(t.charAt(i), 0)-1);
        }

        for(char c : countMap.keySet()) {
            if(countMap.get(c)!=0) {
                return false;
            }
        }
        return true;
    }
}
