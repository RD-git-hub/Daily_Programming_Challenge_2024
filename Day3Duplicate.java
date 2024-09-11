public class Day3Duplicate {
    public static int findDuplicate(int[] arr) {
        int a = arr[0];
        int b = arr[0];
        do {
            a = arr[a];
            b = arr[arr[b]];
        } while (a!= b);
        int entry = arr[0];
        while (entry != a) {
            entry = arr[entry];
            a = arr[a];
        }
        return entry;
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 2};
        int duplicate = findDuplicate(arr);
        System.out.println("The duplicate number is: " + duplicate);
    }
}
