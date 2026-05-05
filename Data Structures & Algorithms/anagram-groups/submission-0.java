class Solution {
    // ask about if all chars in string are lowercase
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> charCountsInString = new HashMap<>();

        for(String str : strs) {
            //fingerprint of a str
            int[] charCount = new int[26];
            for(char c : str.toCharArray()){
                charCount[c-'a']++;
            }

            StringBuilder fingerPrintOfAString = new StringBuilder();
            for(int i=0; i<26; i++) {
                fingerPrintOfAString.append("#");
                fingerPrintOfAString.append(charCount[i]);
            }

            String key = fingerPrintOfAString.toString();

            if(!charCountsInString.containsKey(key)) {
                charCountsInString.put(key, new ArrayList());
            }
            charCountsInString.get(key).add(str);
        }

        return new ArrayList(charCountsInString.values());
    }
}
