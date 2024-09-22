import java.util.HashMap;
public class Day14SubstringCounter {
    public static int countSubstrings(String str, int distinctCount) {
        return countAtMostK(str, distinctCount) - countAtMostK(str, distinctCount - 1);
    }

    private static int countAtMostK(String str, int maxDistinct) {
        int totalSubstrings = 0;
        int start = 0;
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (int end = 0; end < str.length(); end++) {
            frequencyMap.put(str.charAt(end), frequencyMap.getOrDefault(str.charAt(end), 0) + 1);
            while (frequencyMap.size() > maxDistinct) {
                frequencyMap.put(str.charAt(start), frequencyMap.get(str.charAt(start)) - 1);
                if (frequencyMap.get(str.charAt(start)) == 0) {
                    frequencyMap.remove(str.charAt(start));
                }
                start++;
            }
            totalSubstrings += end - start + 1;
        }
        return totalSubstrings;
    }

    public static void main(String[] args) {
        String str = "pqpqs";
        int distinctCount = 2;
        System.out.println(countSubstrings(str, distinctCount));
    }
}
