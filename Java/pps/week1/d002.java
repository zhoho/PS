package pps.week1;

import java.util.Scanner;

public class d002 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int H, W, N;
        for (int i = 0; i < n; i++) {
            H = in.nextInt();
            W = in.nextInt();
            N = in.nextInt();

            int front = N % H;
            int back = (N / H) + 1;

            if (front == 0) {
                front = H;
                back = N / H;
            }
            System.out.println(front * 100 + back);
        }
    }
}
