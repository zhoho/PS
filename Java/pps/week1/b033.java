package pps.week1;

import java.util.Scanner;

public class b033 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T, value, ori, A = 300, B = 60, C = 10;
        int[] ans = new int[3];
        T = in.nextInt();
        ori = T;
        T = (T % A);
        value = (ori / A);
        ans[0] = value;

        ori = T;
        T = (T % B);
        value = (ori / B);
        ans[1] = value;

        ori = T;
        T = (T % C);
        value = (ori / C);
        ans[2] = value;

        if (T != 0)
            System.out.println("-1");
        else
            System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
    }
}
