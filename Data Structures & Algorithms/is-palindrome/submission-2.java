class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("\\s+", "");
        int start = 0;
        int end = s.length()-1;
        while(start<end) {
            while(start<end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            while(start<end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }
            if(s.charAt(start)!=s.charAt(end)) {
                return false;
            }
            else {
                start++;
                end--;
            }
        }
        return true;
    }
}
