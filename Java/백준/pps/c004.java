package 백준.pps;

import java.util.Scanner;

public class c004 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int result = 0;
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            int temp = i;
            int sum = 0;

            while (temp != 0) {
                sum += temp % 10;
                temp /= 10;
            }

            if (sum + i == N) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
