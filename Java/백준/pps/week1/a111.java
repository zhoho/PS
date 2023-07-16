package 백준.pps.week1;

import java.util.Scanner;

public class a111 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int res = 1;
            int n = in.nextInt();
            for (int j = 0; j < n; j++) {
                res *= 2;
            }
            System.out.println(res - 1);
        }
    }
}
