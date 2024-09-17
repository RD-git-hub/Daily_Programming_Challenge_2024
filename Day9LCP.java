public class Day9LCP {
    public static String lcp(String[] s) {
        if (s == null || s.length == 0) return "";
        String p = s[0];
        for (int i = 1; i < s.length; i++) {
            while (s[i].indexOf(p) != 0) {
                p = p.substring(0, p.length() - 1);
                if (p.isEmpty()) return "";
            }
        }
        return p;
    }
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        if (strs != null && strs.length > 0) {
            System.out.println(lcp(strs));
        } else {
            System.out.println("");
        }
    }
}
