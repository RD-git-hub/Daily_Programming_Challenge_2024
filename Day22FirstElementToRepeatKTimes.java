import java.util.HashMap;
public class Day22FirstElementToRepeatKTimes {
    public static int findFirstElement(int[] arr, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        for (int num : arr) {
            if (countMap.get(num) == k) {
                return num;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 4, 5, 2, 6, 1, 4};
        int k = 2;
        System.out.println(findFirstElement(arr, k));
    }
}
