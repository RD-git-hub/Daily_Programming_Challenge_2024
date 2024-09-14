import java.util.*;
public class Day6ZSubarrays {
    public static List<int[]> findZeroSubarrays(int[] arr) {
        List<int[]> res = new ArrayList<>();
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) res.add(new int[]{0, i});
            if (sumMap.containsKey(sum)) {
                for (int idx : sumMap.get(sum)) res.add(new int[]{idx + 1, i});
            }
            sumMap.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }
        return res;
    }
    public static void printSubarrays(List<int[]> subs) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < subs.size(); i++) {
            int[] s = subs.get(i);
            sb.append("(").append(s[0]).append(", ").append(s[1]).append(")");
            if (i != subs.size() - 1) sb.append(", ");
        }
        sb.append("]");
        System.out.println(sb);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 3, -1, 2};
        List<int[]> subs = findZeroSubarrays(arr);
        printSubarrays(subs);
    }
}
