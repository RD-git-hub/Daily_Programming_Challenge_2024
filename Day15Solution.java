import java.util.HashSet;
class Day15Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] chars = new int[128];
        int left = 0, right = 0, maxLength = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            chars[r]++;
            while (chars[r] > 1) {
                char l = s.charAt(left);
                chars[l]--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Day15Solution solution = new Day15Solution();
        String S = "abcabcbb";
        System.out.println(solution.lengthOfLongestSubstring(S));
    }
}
