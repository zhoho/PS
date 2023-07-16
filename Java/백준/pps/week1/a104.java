package 백준.pps.week1;

import java.util.Scanner;

public class a104 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = 0;
        int max = 1;
        for (int i = 0; i < n; i++) {
            int temp = in.nextInt();
            sum += temp;
            if (temp > max) {
                max = temp;
            }
        }
        System.out.println(sum - max);
    }
}
