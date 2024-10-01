import java.util.*;
public class Day23SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] arr, int k) {
        if (arr == null || k <= 0) return new int[0];
        int n = arr.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1) deque.poll();
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) deque.pollLast();
            deque.offer(i);
            if (i >= k - 1) result[i - k + 1] = arr[deque.peek()];
        }
        return result;
    }

    public static void main(String[] args) {
        Day23SlidingWindowMaximum solution = new Day23SlidingWindowMaximum();
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = solution.maxSlidingWindow(arr, k);
        System.out.println(Arrays.toString(result));
    }
}
