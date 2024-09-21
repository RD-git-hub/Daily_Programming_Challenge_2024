public class Day13LongestPalindrome {
    public String findLongestPalindrome(String str) {
        if (str == null || str.length() < 1) return "";
        int leftIndex = 0, rightIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            int lenSingle = expandFromCenter(str, i, i);
            int lenDouble = expandFromCenter(str, i, i + 1);
            int maxLen = Math.max(lenSingle, lenDouble);
            if (maxLen > rightIndex - leftIndex) {
                leftIndex = i - (maxLen - 1) / 2;
                rightIndex = i + maxLen / 2;
            }
        }
        return str.substring(leftIndex, rightIndex + 1);
    }

    private int expandFromCenter(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        Day13LongestPalindrome palindromeFinder = new Day13LongestPalindrome();
        System.out.println(palindromeFinder.findLongestPalindrome("babda"));
    }
}
