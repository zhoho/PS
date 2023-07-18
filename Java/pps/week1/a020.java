package pps.week1;

import java.util.Scanner;

public class a020 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int max = 0;
        int people = 0;
        for (int i = 0; i < 4; i++) {
            int train_out = in.nextInt();
            int train_in = in.nextInt();

            people += (train_in - train_out);
            if (people > max) {
                max = people;
            }
        }
        System.out.println(max);
    }
}
