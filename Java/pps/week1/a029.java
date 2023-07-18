package pps.week1;

import java.util.Scanner;

public class a029 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = in.nextInt();

        if (n > 5) {
            System.out.println("Love is open door");
        } else {
            for (int i = 0; i < n - 1; i++) {
                if (a == 1) {
                    System.out.println(0);
                    a = 0;
                } else {
                    System.out.println(1);
                    a = 1;
                }
            }
        }
    }
}
