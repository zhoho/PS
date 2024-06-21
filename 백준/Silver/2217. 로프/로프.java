import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] lope = new int[n];
        for (int i = 0; i < n; i++) {
            lope[i] = in.nextInt();
        }
        Arrays.sort(lope);
        int max = 0;
        for (int i = n - 1; i >= 0; i--) {
            lope[i] = lope[i] * (n - i);
            if (max < lope[i]) {
                max = lope[i];
            }
        }
        System.out.println(max);
    }
}