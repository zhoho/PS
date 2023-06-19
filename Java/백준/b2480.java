package 백준;

import java.util.Scanner;

public class b2480 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a, b, c;
        a = in.nextInt();
        b = in.nextInt();
        c = in.nextInt();

        if (a == b && a == c && b == c) {
            System.out.println(10000 + a * 1000);
        } else if (a != b && a != c && b != c) {
            int max = a;
            if (max < b)
                max = b;
            if (max < c)
                max = c;
            System.out.println(max * 100);
        } else {
            int same = 0;
            if (a == b)
                same = a;
            else if (a == c)
                same = a;
            else if (b == c)
                same = c;
            System.out.println(1000 + same * 100);
        }
    }
}
