import java.util.Scanner;
public class Day18Divisor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int divisorCount = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) divisorCount++;
        }
        System.out.println(divisorCount);
    }
}
