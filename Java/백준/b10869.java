package 백준;

import java.util.Scanner;

public class b10869 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();

        in.close();

        System.out.println(A + B);
        System.out.println(A - B);
        System.out.println(A * B);
        System.out.println(A / B);
        System.out.println(A % B);
    }
}
