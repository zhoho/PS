package pps.week3;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B077_최지호_20230729 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<BigInteger> list = new ArrayList<>();

        list.add(BigInteger.ZERO);
        list.add(BigInteger.ONE);

        if (0 == n) {
            System.out.println(list.get(0));
            in.close();
            return;
        }
        if (1 == n) {
            System.out.println(list.get(1));
            in.close();
            return;
        }
        for (int i = 2; i <= n; i++) {
            list.add(i, list.get(i - 1).add(list.get(i - 2)));
        }

        System.out.println(list.get(n));

    }
}
