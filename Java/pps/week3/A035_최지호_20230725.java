package pps.week3;

import java.io.IOException;
import java.util.Scanner;

public class A035_최지호_20230725 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String tmp = in.nextLine();
            String[] str = tmp.split(" ");
            Double ans = Double.parseDouble(str[0]);
            for (int j = 1; j < str.length; j++) {
                if (str[j].equals("@"))
                    ans += 3;
                else if (str[j].equals("%"))
                    ans += 5;
                else if (str[j].equals("#"))
                    ans -= 7;
            }
            System.out.println(String.format("%.2f", ans));
        }
    }
}
