package Java;

import java.util.Scanner;

public class b11720 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String num = in.next();

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += num.charAt(i) - '0';
        }

        System.out.print(sum);
        in.close();
    }
}