public class Day2MissingNo {
    public static int MissingNumber(int[] arr, int n) {
        int totalSum = n * (n + 1) / 2;
        int arraySum = 0;
        for (int num : arr) {
            arraySum += num;
        }
        return totalSum - arraySum;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,6}; 
        int n = 6;
        System.out.println("Missing number: " + MissingNumber(arr, n));
    }
}
