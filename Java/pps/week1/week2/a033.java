package pps.week1.week2;

import java.util.Scanner;

public class a033 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sum;
        int max = 0;
        int winner = 0;
        for (int i = 0; i < 5; i++) {
            sum = 0;
            for (int j = 0; j < 4; j++) {
                int score = in.nextInt();
                sum += score;
            }
            if (sum > max) {
                max = sum;
                winner = i + 1;
            }
        }
        System.out.println(winner + " " + max);
    }
}
